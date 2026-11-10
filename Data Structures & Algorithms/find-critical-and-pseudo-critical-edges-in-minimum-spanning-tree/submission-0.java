class Solution {
    // Flattened Union-Find state tracking
    private int[] parent;

    // Helper method to find the representative root of a node with path compression
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    // Helper method to union two disjoint sets
    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        
        // Store: [u, v, weight, original_index]
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i; 
        }

        // Sort edges by weight to apply Kruskal's algorithm
        Arrays.sort(newEdges, (a, b) -> Integer.compare(a[2], b[2]));

        // Calculate the standard baseline weight of the MST
        int originalMST = getMST(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            // 1. Check if the edge is CRITICAL:
            // Force skip this edge. If the resulting weight increases (or graph disconnects), it's critical.
            if (getMST(n, newEdges, i, -1) > originalMST) {
                critical.add(newEdges[i][3]);
            } 
            // 2. Check if the edge is PSEUDO-CRITICAL:
            // Force add this edge first. If we can still achieve the original MST weight, it's pseudo-critical.
            else if (getMST(n, newEdges, -1, i) == originalMST) {
                pseudoCritical.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(critical, pseudoCritical);
    }

    private int getMST(int n, int[][] edges, int skip, int add) {
        // Re-initialize parent array for the current graph simulation
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int weight = 0;
        int count = 0;

        // If an edge must be forcibly added first (Pseudo-critical check)
        if (add != -1) {
            union(edges[add][0], edges[add][1]);
            weight += edges[add][2];
            count++;
        }

        // Standard Kruskal's build loop
        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;
            
            if (union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
                count++;
            }
        }

        // Check if all nodes managed to connect into a single component
        int root = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != root) {
                return Integer.MAX_VALUE;
            }
        }

        return count == n - 1 ? weight : Integer.MAX_VALUE;
    }
}
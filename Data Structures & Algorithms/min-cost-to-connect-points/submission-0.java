class Solution {
    // A compact DSU class with Path Compression and Union by Rank
    class UnionFind {
        int[] parent;
        int[] rank;
        int components;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Path compression
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                // Union by rank optimization
                if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                components--;
                return true; // Union successful, edge can be added
            }
            return false; // Already in the same component, skip to avoid cycle
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Total possible edges in a fully connected graph is n * (n - 1) / 2
        List<int[]> edges = new ArrayList<>();

        // Step 1: Calculate and store all possible edges {weight, u, v}
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }

        // Step 2: Sort all edges in non-decreasing order of their weight
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;

        // Step 3: Iterate through sorted edges and connect components
        for (int[] edge : edges) {
            int weight = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (uf.union(u, v)) {
                totalCost += weight;
                edgesUsed++;
                // Optimization: Stop early if we have connected all n points with n-1 edges
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Base case: If there is only one node, it is the root of the MHT
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Initialize the adjacency list and degree array
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        // Initialize the queue with all initial leaf nodes (degree == 1)
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }

        // Trim the leaves layer by layer until 1 or 2 centroids remain
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                
                for (int neighbor : graph[leaf]) {
                    degree[neighbor]--;
                    // If the neighbor becomes a leaf node, add it to the queue
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        // The remaining nodes in the queue are the centroids
        return new ArrayList<>(leaves);
    }
}

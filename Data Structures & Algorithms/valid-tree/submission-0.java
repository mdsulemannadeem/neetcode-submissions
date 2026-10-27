class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Condition 2: Check for cycles starting from node 0
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }

        // Condition 3: Ensure the graph is fully connected
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int u, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        
        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            
            if (!visited[v]) {
                if (hasCycle(v, u, graph, visited)) {
                    return true;
                }
            } else if (v != parent) {
                return true; // Visited + not parent = cycle found
            }
        }
        return false;
    }
}

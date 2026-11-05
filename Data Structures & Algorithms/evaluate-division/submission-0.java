class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // 1. Build the adjacency list representation of the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        // 2. Evaluate each query using DFS
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, visited, graph);
            }
        }

        return results;
    }

    private double dfs(String x, String y, Set<String> vis, Map<String, Map<String, Double>> g) {
        if (x.equals(y)) {
            return 1.0;
        }
        vis.add(x);

        Map<String, Double> neighbors = g.get(x);
        if (neighbors != null) {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String nextNode = entry.getKey();
                double weight = entry.getValue();

                if (!vis.contains(nextNode)) {
                    double subResult = dfs(nextNode, y, vis, g);
                    if (subResult != -1.0) {
                        return weight * subResult;
                    }
                }
            }
        }

        return -1.0;
    }
}


class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            // Invalid prefix
            if (j == len) {
                if (w1.length() > w2.length()) {
                    return "";
                }
                continue;
            }

            char u = w1.charAt(j);
            char v = w2.charAt(j);

            if (graph.get(u).add(v)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        // Topological sort using BFS
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder order = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            order.append(c);

            for (char next : graph.get(c)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // Detect cycle
        return order.length() == indegree.size() ? order.toString() : "";
    }
}

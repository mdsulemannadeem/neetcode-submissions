class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // isPre[i][j] will be true if course i is a prerequisite of course j
        boolean[][] isPre = new boolean[numCourses][numCourses];
        
        for (int[] pre : prerequisites) {
            int u = pre[0]; // prerequisite
            int v = pre[1]; // next course
            graph.get(u).add(v);
            inDegree[v]++;
            isPre[u][v] = true; // Direct prerequisite
        }
        
        // Step 2: Push all nodes with 0 in-degree into the BFS queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process nodes in Topological Order using Kahn's Algorithm
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v : graph.get(u)) {
                // Simple for loop: pass down all accumulated prerequisites from u to v
                for (int i = 0; i < numCourses; i++) {
                    if (isPre[i][u]) {
                        isPre[i][v] = true;
                    }
                }
                
                // Decrement in-degree and add to queue if it becomes 0
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        // Step 4: Answer the queries in O(1) time
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPre[query[0]][query[1]]);
        }
        
        return result;
    }
}

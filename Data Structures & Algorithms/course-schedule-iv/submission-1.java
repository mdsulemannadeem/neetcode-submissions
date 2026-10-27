class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // isPre[i][j] will be true if course i is a prerequisite of course j
        boolean[][] isPre = new boolean[n][n];
        
        // Step 1: Map all direct prerequisites using a simple loop
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            isPre[u][v] = true;
        }
        
        // Step 2: Floyd-Warshall to find indirect (transitive) prerequisites
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isPre[i][k] && isPre[k][j]) {
                        isPre[i][j] = true;
                    }
                }
            }
        }
        
        // Step 3: Answer each query using a simple loop
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            result.add(isPre[u][v]);
        }
        
        return result;
    }
}

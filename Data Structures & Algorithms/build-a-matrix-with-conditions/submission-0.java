class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topoSort(k, rowConditions);
        int[] colOrder = topoSort(k, colConditions);
        
        if (rowOrder.length == 0 || colOrder.length == 0) {
            return new int[0][0];
        }
        
        int[][] matrix = new int[k][k];
        int[] posInCol = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            posInCol[colOrder[i]] = i;
        }
        
        for (int i = 0; i < k; i++) {
            int val = rowOrder[i];
            matrix[i][posInCol[val]] = val;
        }
        
        return matrix;
    }

    private int[] topoSort(int k, int[][] conditions) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[k + 1];
        for (int[] edge : conditions) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] result = new int[k];
        int index = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[index++] = curr;
            
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        
        return index == k ? result : new int[0];
    }
}

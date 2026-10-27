class Solution {
    public int countComponents(int n, int[][] edges) {
int count = 0;
List<List<Integer>> adj = new ArrayList<>();
for(int i = 0; i< n;i++){
    adj.add(new ArrayList<>());
}

for(int i = 0; i <edges.length;i++){
    adj.get(edges[i][0]).add(edges[i][1]);
     adj.get(edges[i][1]).add(edges[i][0]);
}
   boolean[] visited = new boolean[n];
for(int i = 0;i < n;i++){
    if(!visited[i]){
        dfs(i,adj,visited);
        count++;
    }
}
return count;
    }
      private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}

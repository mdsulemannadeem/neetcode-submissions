class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
    int[] indegree = new int[n];

    for(int i = 0; i < prerequisites.length; i++){
        int course = prerequisites[i][0], pre = prerequisites[i][1];
        graph.get(pre).add(course);
        indegree[course]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < n; i++){
        if(indegree[i] == 0) q.offer(i);           // koi dependency nahi
    }

    int[] order = new int[n];
    int idx = 0;
    while(!q.isEmpty()){
        int u = q.poll();
        order[idx++] = u;
        for(int i = 0; i < graph.get(u).size(); i++){
            int v = graph.get(u).get(i);
            indegree[v]--;
            if(indegree[v] == 0) q.offer(v);       // ab ready
        }
    }
    return idx == n ? order : new int[0];   
    }
}

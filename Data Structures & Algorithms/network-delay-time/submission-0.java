class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int wt = times[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = wt + dist[u];
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) { // Start from 1 because nodes are 1-indexed
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // A node is unreachable
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
          int INF = Integer.MAX_VALUE;
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    dist[src] = 0;

    for(int round = 0; round <= k; round++){
        int[] temp = Arrays.copyOf(dist, n);                  // pichle round ki snapshot
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0], v = flights[i][1], w = flights[i][2];
            if(dist[u] != INF && dist[u] + w < temp[v]){
                temp[v] = dist[u] + w;                        // dist[] se padho, temp[] mein likho
            }
        }
        dist = temp;
    }
    return dist[dst] == INF ? -1 : dist[dst];
    }
}

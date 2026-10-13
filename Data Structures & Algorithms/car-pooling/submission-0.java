class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Arrays.sort(trips,(a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int currentPassengers = 0;
        for(int i = 0;i < n;i++){
               int passengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
             while(!pq.isEmpty() && pq.peek()[0] <= start){
                int [] dropped = pq.poll();
        currentPassengers -= dropped[1];
    }
      currentPassengers += passengers;
     if(currentPassengers > capacity){
        return false;
     }

     pq.offer(new int[]{end, passengers});

   
        }
   return true;
    }
}
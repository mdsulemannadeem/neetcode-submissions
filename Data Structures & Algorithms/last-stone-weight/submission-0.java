class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i = 0;i <stones.length;i++){
        pq.offer(stones[i]);
       } 
while (pq.size() > 1){
  int top = pq.poll();
  int second = pq.poll();
       if(top > second){
       pq.offer(top - second);
       }
}
pq.offer(0);
    return Math.abs(pq.peek());
     
    }
}

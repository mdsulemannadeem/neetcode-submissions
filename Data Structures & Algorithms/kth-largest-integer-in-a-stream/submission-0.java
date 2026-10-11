class KthLargest {
private final PriorityQueue<Integer> pq;
   private final int k;
    public KthLargest(int k, int[] nums) {
     this.k = k;
        this.pq = new PriorityQueue<>(k);
        for(int i = 0; i< nums.length;i++){
add(nums[i]);
        }
     
    }
    
    public int add(int val) {
     pq.offer(val);
                
            if(pq.size() > k){
                pq.poll();
            }
   return pq.peek();

    }
}

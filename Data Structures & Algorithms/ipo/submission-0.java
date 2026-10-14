class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // {capital, profit}
PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

for(int i = 0; i < capital.length; i++){
    minCapitalHeap.offer(new int[]{capital[i], profits[i]});
}

for(int round = 0; round < k; round++){
    // jitne projects abhi ke capital se "unlock" ho sakte hain, unlock karo
    while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w){
        maxProfitHeap.offer(minCapitalHeap.poll()[1]);
    }
    if(maxProfitHeap.isEmpty()) break;   // koi project affordable nahi hai

    w += maxProfitHeap.poll();   // sabse profitable unlocked project uthao
}
return w;
    }
}
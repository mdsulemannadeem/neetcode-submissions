class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = piles[0];
        for(int i = 0;i<piles.length;i++){
            if(piles[i] > end){
                end = piles[i];
            }
        }
int ans = end;
        while(start <= end){
int mid = start + (end - start)/2;

if(canAchieve(piles,mid) <= h){
ans = mid;
end = mid - 1;
}else{
    start = mid + 1;
}
        }
        return ans;

    }
      private long canAchieve(int[] piles, int mid) {
        long total = 0;
        for (int i = 0; i < piles.length; i++) {
            // Fix integer division bug by casting to double, or using integer math
            total += (piles[i] + mid - 1) / mid;
        }
        return total;
    }
    
}

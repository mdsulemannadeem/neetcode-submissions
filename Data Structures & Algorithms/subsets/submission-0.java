class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        
        // Start the backtracking process from index 0
        solve(nums, 0, diary, result);
        
        return result;  
    }
   private void solve(int[] nums, int idx, List<Integer> diary, List<List<Integer>> result){
   if(idx == nums.length){
    result.add(new ArrayList<>(diary));
    return;
   }
   diary.add(nums[idx]);
   solve(nums,idx + 1,diary,result);
   diary.remove(diary.size() - 1);
   solve(nums,idx + 1,diary,result);
}
}

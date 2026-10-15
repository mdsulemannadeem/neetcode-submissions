class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
         backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }
     private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if(remain < 0){
            return;
        }else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = start; i<nums.length;i++){
                if(remain - nums[i] <0){
                    break;
                }
                tempList.add(nums[i]);
                backtrack(result,tempList, nums, remain-nums[i], i);
                tempList.remove(tempList.size()-1);
               
            }
        }
     }
}

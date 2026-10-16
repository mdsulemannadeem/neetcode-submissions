class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> result = new ArrayList<>();
         solve(nums,0, new ArrayList<>(), result);
        return result;
    }
      private void solve(int[] nums, int idx, List<Integer> diary, List<List<Integer>> result){


    result.add(new ArrayList<>(diary));

    for(int i = idx ; i <nums.length;i++){
if(i > idx && nums[i] == nums[i - 1]) continue;
diary.add(nums[i]);
   solve(nums,i + 1,diary,result);
   diary.remove(diary.size() - 1);
    }
   
 
   
}
}

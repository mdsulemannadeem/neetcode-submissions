class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums,used,new ArrayList<>(),result);
        return result;
    }
    void solve(int[] nums, boolean[] used, List<Integer> diary, List<List<Integer>> result){
 if(diary.size() == nums.length){
 result.add(new ArrayList<>(diary));
 return;
 }
 for(int i = 0; i < nums.length; i++){
 if(used[i]) continue; // already use ho chuka
 used[i] = true;
 diary.add(nums[i]);
 solve(nums, used, diary, result);
 diary.remove(diary.size() - 1); // undo (dono!)
 used[i] = false;
 }
}

}

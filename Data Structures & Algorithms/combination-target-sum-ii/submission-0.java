class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);  
      List<List<Integer>>result = new ArrayList<>();
      backtrack(result,new ArrayList<>(), candidates, target, 0);
      return result;

    }
    private void backtrack(List<List<Integer>>result,List<Integer> diary,int[] candidates, int target,int start){
         if(target < 0){
            return;
        }else if (target == 0) {
            result.add(new ArrayList<>(diary));
        }else{
            for(int i = start; i<candidates.length;i++){
                 if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
                if(target - candidates[i] <0){
                    break;
                }
                diary.add(candidates[i]);
                backtrack(result,diary, candidates, target-candidates[i], i+1);
                diary.remove(diary.size()-1);
              
               
            }
        }
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
       solve(n,k,1,new ArrayList<>(),result);
       return result;       
    }
    private void solve(int n, int k, int start, List<Integer> diary, List<List<Integer>> result){
 if(diary.size() == k){ result.add(new ArrayList<>(diary)); return; }
 for(int i = start; i <= n - (k - diary.size()) + 1; i++){ // PRUNE: itne numbers bache hi nahi
 diary.add(i);
 solve(n, k, i + 1, diary, result);
 diary.remove(diary.size() - 1);
 }
}
}
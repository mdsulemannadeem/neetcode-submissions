class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s,0,new ArrayList<>(),result);
        return result;
    }

  private void solve(String s, int start, List<String> diary, List<List<String>> result){
  if(s.length() == start){
    result.add(new ArrayList<>(diary));
return;
    }
    for(int end = start;end < s.length();end++){
        if(!isPalindrome(s, start, end)) continue;  
        diary.add(s.substring(start, end + 1));
        solve(s,end+1,diary,result);
        diary.remove(diary.size()-1);
    }
  }
  private boolean isPalindrome(String s, int start, int end){
    if(start >= end) return true;                         // base: 0 ya 1 char
    if(s.charAt(start) != s.charAt(end)) return false;    // outer match nahi → seedha false
    return isPalindrome(s, start + 1, end - 1);           // phir inside check
}

  }
  
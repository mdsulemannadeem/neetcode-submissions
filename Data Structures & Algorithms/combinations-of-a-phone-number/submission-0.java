class Solution {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
           if (digits == null || digits.isEmpty()) {
            return result; // return empty list
        }
        solve(digits,0,new StringBuilder(),result);
        return result;
    }
    private void solve(String digits, int idx, StringBuilder diary, List<String> result){
    if(idx == digits.length()){                       // saari stages done
        result.add(diary.toString());                 // StringBuilder ka snapshot = toString()
        return;
    }
    String letters = map[digits.charAt(idx) - '0'];   // is stage ke choices
    for(int i = 0; i < letters.length(); i++){
        diary.append(letters.charAt(i));              // add
        solve(digits, idx + 1, diary, result);        // recurse
        diary.deleteCharAt(diary.length() - 1);       // undo
    }
}
}

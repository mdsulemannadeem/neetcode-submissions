class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLen = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int end = 0 ; end < s.length();end++){
            char ch = s.charAt(end);
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
            while (freq.get(ch) > 1) {
                char leftChar = s.charAt(start);
                freq.put(leftChar,freq.get(leftChar)-1);
                start++;
            }
            maxLen = Math.max(maxLen,end- start + 1);
        }
        return maxLen;
    }
}

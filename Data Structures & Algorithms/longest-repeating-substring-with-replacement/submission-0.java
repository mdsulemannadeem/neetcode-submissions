class Solution {
    public int characterReplacement(String s, int k) {
        return countAtMostK(s, k);
    }

    int countAtMostK(String s, int k){
    int left = 0;
    int maxLen = 0;
            int maxFreq = 0; 
    Map<Character, Integer> freq = new HashMap<>();

    for(int right = 0; right < s.length(); right++){
        char c= s.charAt(right);
        freq.put(c, freq.getOrDefault(c, 0) + 1); 
         maxFreq = Math.max(maxFreq, freq.get(c));
      while ((right - left + 1) - maxFreq > k) {
                char lv = s.charAt(left);
                freq.put(lv, freq.get(lv) - 1);
                left++;
            }
maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
}

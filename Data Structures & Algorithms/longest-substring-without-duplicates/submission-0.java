class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char sami = s.charAt(end);
            map.put(sami, map.getOrDefault(sami, 0) + 1);
            while (map.get(sami) >= 2) {
                char lc = s.charAt(start);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0)
                    map.remove(lc);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}

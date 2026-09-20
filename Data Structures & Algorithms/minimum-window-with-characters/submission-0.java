class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        int required = need.size(), formed = 0;
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1); // same expand line
            if (need.containsKey(c) && windowCount.get(c).intValue() == need.get(c).intValue())
                formed++;

            while (formed == required) { // <-- shrink-while-VALID (base ka ulta)
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lc = s.charAt(left);
                windowCount.put(lc, windowCount.get(lc) - 1);
                if (need.containsKey(lc) && windowCount.get(lc).intValue() < need.get(lc).intValue())
                    formed--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
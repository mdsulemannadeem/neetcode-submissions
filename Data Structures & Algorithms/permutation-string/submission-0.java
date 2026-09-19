class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int [] need = new int [26];
        for(int i = 0; i < s1.length();i++){
            need[s1.charAt(i) - 'a']++;
        }
        int [] windowFreq = new int[26];
        int k = s1.length();
         for(int i = 0; i < s2.length();i++){
            windowFreq[s2.charAt(i) - 'a']++;

            if(i >= k) windowFreq[s2.charAt(i - k) - 'a']--;
            if(i >= k-1 && Arrays.equals(need,windowFreq)) return true;
        }
        return false;
    }
}

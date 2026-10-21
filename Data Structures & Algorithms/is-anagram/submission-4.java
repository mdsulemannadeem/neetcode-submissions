class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) {
            return false;
        }
int[] need = new int[26];
for(int i = 0; i < s.length(); i++) need[s.charAt(i) - 'a']++;

int[] windowFreq = new int[26];
int k = s.length();

for(int i = 0; i < t.length(); i++){
    windowFreq[t.charAt(i) - 'a']++;
    if(i >= k) windowFreq[t.charAt(i - k) - 'a']--;   // <-- same "add-hatao" idea, freq array pe
    if(i >= k - 1 && Arrays.equals(need, windowFreq)) return true;
}
return false;
    }
}

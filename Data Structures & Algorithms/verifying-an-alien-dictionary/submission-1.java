class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      HashMap<Character, Integer> map = new HashMap<>();
for (int i = 0; i < order.length(); i++) {
    char c = order.charAt(i);
    map.putIfAbsent(c, i);
}

  for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            // Invalid prefix
            if (j == len) {
                if (w1.length() > w2.length()) {
                    return false;
                }
                continue;
            }

            char u = w1.charAt(j);
            char v = w2.charAt(j);
              if (map.get(u) > map.get(v)) {
                return false; // w1 comes AFTER w2 in custom order
            }
         
        }

        // Detect cycle
        return true;
    }
}
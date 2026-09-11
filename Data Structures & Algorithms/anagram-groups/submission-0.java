class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the groups of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the string to use as a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Add the string to the corresponding group in the map
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
  
    }
}

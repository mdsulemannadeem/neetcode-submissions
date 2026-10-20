class Solution {
    // Memoization map to store structural results of processed substrings
    private Map<String, List<String>> memo;
    private Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        // Convert list to HashSet for O(1) rapid lookups
        wordSet = new HashSet<>(wordDict);
        
        return backtrack(s);
    }

    private List<String> backtrack(String s) {
        // Base case: If we already calculated paths for this substring, return it
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        // Base case: If the string itself is a valid word, add it to our valid cuts
        if (wordSet.contains(s)) {
            result.add(s);
        }

        // Partition the string at every possible index 'i'
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            
            // If the prefix matches a word in our dictionary, solve for the remaining suffix
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixSubSolutions = backtrack(suffix);
                
                // Combine the current prefix with all valid suffix sentences
                for (String subSolution : suffixSubSolutions) {
                    result.add(prefix + " " + subSolution);
                }
            }
        }

        // Cache the calculated sentences for the current substring 's'
        memo.put(s, result);
        return result;
    }
}
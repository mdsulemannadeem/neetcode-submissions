class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Put all words in a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 2. Queue for standard BFS traversal
        Queue<String> queue = new LinkedList<>();
        
        // 3. HashMap to track the level/distance of each word
        Map<String, Integer> wordLevelMap = new HashMap<>();

        // Initialize BFS with the beginWord
        queue.add(beginWord);
        wordLevelMap.put(beginWord, 1);
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentLevel = wordLevelMap.get(currentWord);

            // If we match our destination word, return the transformation distance
            if (currentWord.equals(endWord)) {
                return currentLevel;
            }

            char[] chars = currentWord.toCharArray();
            
            // Loop through each character position of the word
            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];

                // Attempt changing character to everything from 'a' through 'z'
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) {
                        continue;
                    }
                    
                    chars[i] = c;
                    String nextWord = new String(chars);

                    // If the modified string exists inside our valid dictionary
                    if (wordSet.contains(nextWord)) {
                        queue.add(nextWord);
                        
                        // Track the calculated transition depth inside our HashMap
                        wordLevelMap.put(nextWord, currentLevel + 1);
                        
                        // Mark as visited by stripping it out of the master collection
                        wordSet.remove(nextWord);
                    }
                }
                // Backtrack: revert the temporary state modification back
                chars[i] = originalChar;
            }
        }
        
        return 0;
    }
}

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        
        int sum = 0;
        for (int match : matchsticks) sum += match;
        if (sum % 4 != 0) return false;
        int targetSide = sum / 4;
        
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > targetSide) return false;
        
        int[] sides = new int[4];
        return backtrack(matchsticks, matchsticks.length - 1, sides, targetSide);
    }
    
    private boolean backtrack(int[] matchsticks, int index, int[] sides, int target) {
        if (index < 0) {
            return true;
        }
        
        int currentMatchstick = matchsticks[index];
        
        // Try to place the current matchstick into one of the 4 sides
        for (int i = 0; i < 4; i++) {
            
            // 1. CHOOSE: Check if the matchstick fits into side 'i'
            if (sides[i] + currentMatchstick <= target) {
                
                // An optimization to skip duplicate side configurations
                if (i > 0 && sides[i] == sides[i - 1]) continue;
                
                // STEP 1: Make the move (Add matchstick to side)
                sides[i] += currentMatchstick;
                
                // STEP 2: RECURE (Move to the next matchstick)
                if (backtrack(matchsticks, index - 1, sides, target)) {
                    return true; 
                }
                
                // STEP 3: BACKTRACK (Undo the move if it didn't work out)
                sides[i] -= currentMatchstick;
            }
        }
        
        // If the matchstick couldn't fit into any side configuration, trigger backtracking up the chain
        return false;
    }
}

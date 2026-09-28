class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Initialize the tortoise and the hare
        int tortoise = nums[0];
        int hare = nums[0];
        
        // Step 2: Move hare twice as fast as tortoise until they meet inside the cycle
        do {
            tortoise = nums[tortoise];       // moves 1 step
            hare = nums[nums[hare]];         // moves 2 steps
        } while (tortoise != hare);
        
        // Step 3: Find the entrance to the cycle (the duplicate number)
        tortoise = nums[0];                  // reset tortoise to start
        while (tortoise != hare) {
            tortoise = nums[tortoise];       // moves 1 step
            hare = nums[hare];               // moves 1 step
        }
        
        return tortoise;                     // or return hare;
    }
}

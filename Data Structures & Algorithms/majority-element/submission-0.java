class Solution { 
    public int majorityElement(int[] nums) { 
        int candidate = 0; 
        int count = 0; 
        
        // Using a simple index-based for loop
        for (int i = 0; i < nums.length; i++) { 
            if (count == 0) { 
                candidate = nums[i]; 
            } 
            count += (nums[i] == candidate) ? 1 : -1; 
        } 
        
        return candidate; 
        } 
}

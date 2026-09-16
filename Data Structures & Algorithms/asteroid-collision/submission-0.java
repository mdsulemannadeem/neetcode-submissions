class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
    
        for(int i = 0; i< asteroids.length;i++){
            int ast = asteroids[i];
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && ast < 0){
 if (Math.abs(ast) > stack.peek()) {
                    stack.pop(); // Stack top explodes, keep checking next stack elements
                    continue; 
                } 
                // Case 2: Both are the same size
                else if (Math.abs(ast) == stack.peek()) {
                    stack.pop();     // Stack top explodes
                    destroyed = true; // Incoming asteroid also explodes
                    break;           // Collision resolved
                } 
                // Case 3: The stack top is bigger
                else {
                    destroyed = true; // Incoming asteroid explodes
                    break;           // Collision resolved
                }
                            }
                            if (!destroyed) {
                stack.push(ast);
            }
            
        }
          int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Character> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        int k = 0; 

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); 

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); 
            } 
            else if (ch == '[') {
                st2.push(k);
                k = 0;
                st1.push(ch);
            } 
            else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                while (st1.peek() != '[') {
                    temp.insert(0, st1.pop()); 
                }
                st1.pop(); // Remove '['

                int repeatCount = st2.pop();
                String repeatedStr = temp.toString().repeat(repeatCount);

                // Modified: Using a simple indexed for loop to push characters back
                for (int j = 0; j < repeatedStr.length(); j++) {
                    st1.push(repeatedStr.charAt(j));
                }
            } 
            else {
                st1.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        // Modified: Using a simple indexed for loop to construct the final string
        for (int i = 0; i < st1.size(); i++) {
            result.append(st1.get(i));
        }
        return result.toString();
    }
}

class Solution {
    public String decodeString(String s) {
        // st1 holds strings built so far, st2 holds multipliers
        Stack<String> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        String currentStr = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                // Save our current progress and multiplier before entering brackets
                st1.push(currentStr);
                st2.push(k);
                // Reset for the inside context
                currentStr = "";
                k = 0;
            } 
            else if (ch == ']') {
                // Decode the bracket block efficiently
                StringBuilder temp = new StringBuilder();
                String previousStr = st1.pop();
                int repeatCount = st2.pop();

                // Start with the outer string context
                temp.append(previousStr);

                // Append the inner string 'repeatCount' times using simple loop
                for (int j = 0; j < repeatCount; j++) {
                    temp.append(currentStr);
                }

                currentStr = temp.toString();
            } 
            else {
                // Standard character, just grow our active string
                currentStr += ch;
            }
        }

        return currentStr;
    }
}

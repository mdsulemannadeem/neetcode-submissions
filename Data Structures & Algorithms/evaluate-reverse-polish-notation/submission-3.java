class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
             String letter =  tokens[i];
            if(letter.equals("+")){
                    int b = s.pop();
                int a = s.pop();
                s.push(a + b);
            }else if(letter.equals("-")){
                       int b = s.pop();
                int a = s.pop();
                s.push(a - b);
            }else if(letter.equals("*")){
                int b = s.pop();
                int a = s.pop();
                s.push(a * b);
            }else if(letter.equals("/")){
                int b = s.pop();
                int a = s.pop();
                s.push(a / b);
            }else{
                 s.push(Integer.parseInt(letter));
            }
        }
          return s.pop();
    }
}

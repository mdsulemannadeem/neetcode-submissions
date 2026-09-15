class Solution {
    public int calPoints(String[] operations) {
         Stack<Integer> s = new Stack<>();

         for(int i = 0; i < operations.length;i++){
            String letter =  operations[i];
            if(letter.equals("+")){
                  int top = s.pop();
                  int newTop = top + s.peek();
                  s.push(top);
                  s.push(newTop);
            }else if(letter.equals("D")){
               s.push(2 * s.peek());
            }else if (letter.equals("C")){
                    s.pop();
                    }else{
                         s.push(Integer.parseInt(letter));
                    }
         }

            
        int totalSum = 0;
        for (int i = 0; i < s.size(); i++) {
            totalSum += s.get(i); 
        }
        
        return totalSum;
    }
}
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

    int [][] pair = new int[n][2];
    for(int i = 0;i < n;i++){
        pair[i][0] = position[i];
         pair[i][1] = speed[i];
    }

    Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

    Stack<Double> st = new Stack<>();

    for(int i = 0;i < n;i++){
        double currentTime = (double) (target - pair[i][0]) / pair[i][1];
        st.push(currentTime);

        if(st.size() >= 2 && st.peek() <= st.get(st.size() - 2)){
            st.pop();
        }

    
    }
        return st.size();
    }
}
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while (start <= end) {
            // Prevents integer overflow compared to (start + end) / 2
            int mid = start + (end - start) / 2; 
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // Found the picked number
            } else if (res == -1) {
                end = mid - 1; // Your guess is higher than the picked number, search lower half
            } else {
                start = mid + 1; // Your guess is lower than the picked number, search upper half
            }
        }
        
        return start;
    }
}

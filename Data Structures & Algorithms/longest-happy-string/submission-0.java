class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-heap to store characters and their remaining counts, sorted by count descending
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        if (a > 0) maxHeap.offer(new int[]{'a', a});
        if (b > 0) maxHeap.offer(new int[]{'b', b});
        if (c > 0) maxHeap.offer(new int[]{'c', c});
        
        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            int len = result.length();
            
            // Check if the most frequent character would cause 3-in-a-row
            if (len >= 2 && result.charAt(len - 1) == first[0] && result.charAt(len - 2) == first[0]) {
                // We cannot use 'first'. We need the next most frequent character.
                if (maxHeap.isEmpty()) {
                    // No other characters available, we must stop here
                    break;
                }
                
                int[] second = maxHeap.poll();
                result.append((char) second[0]);
                second[1]--;
                
                if (second[1] > 0) {
                    maxHeap.offer(second);
                }
                
                // Put the 'first' character back into the heap for the next iterations
                maxHeap.offer(first);
            } else {
                // Safe to use the most frequent character
                result.append((char) first[0]);
                first[1]--;
                
                if (first[1] > 0) {
                    maxHeap.offer(first);
                }
            }
        }
        
        return result.toString();
    }
}

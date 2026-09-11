/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
// 1. Sort using object fields instead of array brackets
Collections.sort(intervals, (a, b) -> a.start - b.start);

PriorityQueue<Integer> heap = new PriorityQueue<>(); // stores end times

for(int i = 0; i < intervals.size(); i++){
    // 2. Get the Interval object directly
    Main.Interval iv = intervals.get(i);
    
    // 3. Access the fields using dot notation (.start and .end)
    if(!heap.isEmpty() && heap.peek() <= iv.start){
        heap.poll(); // sabse jaldi khaali hone wala room reuse karo
    }
    heap.offer(iv.end);
}

return heap.size();
  
    }
}

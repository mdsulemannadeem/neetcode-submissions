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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // 1. Sort the List using .start
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        // 2. Use .size() instead of .length
        for (int i = 1; i < intervals.size(); i++) {
            // 3. Use .get(i) and .start / .end
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        
        return true;
    }
}

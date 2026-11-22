class Solution {
   public int[][] merge(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start
    
    List<int[]> res = new ArrayList<>();
    
    int start = intervals[0][0];
    int end   = intervals[0][1];
    
    for (int i = 1; i < n; i++) {
        int s = intervals[i][0];
        int e = intervals[i][1];
        
        if (end >= s) { // overlap condition
            end = Math.max(end, e);
        } else {
            res.add(new int[]{start, end});
            start = s;
            end   = e;
        }
    }
    res.add(new int[]{start, end}); // last interval
    
    return res.toArray(new int[res.size()][]);
}
}
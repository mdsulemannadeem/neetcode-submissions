class Solution {
    // Definining a lightweight Pair class to represent [processingTime, originalIndex]
    private static class Pair {
        int processTime;
        int index;

        Pair(int processTime, int index) {
            this.processTime = processTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        // Sort tasks by enqueue time
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-Heap using the Pair class: prioritizes processTime, breaks ties with index
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
            a.processTime != b.processTime ? Integer.compare(a.processTime, b.processTime) : Integer.compare(a.index, b.index)
        );
        
        int[] result = new int[n];
        long time = 0; // Keeping long to prevent integer overflow
        int i = 0, resIdx = 0;
        
        while (resIdx < n) {
            // Add all tasks that have arrived by current time
            while (i < n && sortedTasks[i][0] <= time) {
                pq.offer(new Pair(sortedTasks[i][1], sortedTasks[i][2]));
                i++;
            }
            
            if (pq.isEmpty()) {
                time = sortedTasks[i][0];
                continue;
            }
            
            Pair bestTask = pq.poll();
            result[resIdx++] = bestTask.index;
            time += bestTask.processTime;
        }
        
        return result;
    }
}

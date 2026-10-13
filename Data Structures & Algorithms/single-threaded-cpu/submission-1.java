class Solution {
    public int[] getOrder(int[][] tasks) {

         int n = tasks.length;
        int[] result = new int[n];
        
        // 1. Store task details: [enqueueTime, processingTime, originalIndex]
        int[][] extendedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            extendedTasks[i][0] = tasks[i][0]; // Enqueue Time
            extendedTasks[i][1] = tasks[i][1]; // Processing Time
            extendedTasks[i][2] = i;           // Original Index
        }
        
        // 2. Sort tasks chronologically by their enqueue time
        Arrays.sort(extendedTasks, (a, b) -> Integer.compare(a[0], b[0]));


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        long currentTime = 0;
        int taskIdx = 0;
        int resIdx = 0;
        
        // 4. Process all tasks
        while (taskIdx < n || !pq.isEmpty()) {
            // If the heap is empty and the next task arrives in the future, jump time forward
            if (pq.isEmpty() && currentTime < extendedTasks[taskIdx][0]) {
                currentTime = extendedTasks[taskIdx][0];
            }
            
            // Add all tasks that have arrived by the current time to the heap
            while (taskIdx < n && extendedTasks[taskIdx][0] <= currentTime) {
                pq.offer(extendedTasks[taskIdx]);
                taskIdx++;
            }
            
            // Process the highest priority available task
            int[] currentTask = pq.poll();
            result[resIdx++] = currentTask[2];
            currentTime += currentTask[1]; // Advance time by task duration
        }
        
        return result;


    }
}
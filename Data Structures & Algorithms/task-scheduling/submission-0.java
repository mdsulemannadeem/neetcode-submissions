class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        // Step 2: Use Max-Heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        int time = 0;
        // Step 3: Process tasks
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // Process n + 1 tasks in each cycle
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1);
                }
            }

            // Add back tasks that still have remaining frequency
            for (int i = 0; i < temp.size(); i++) {
                int f = temp.get(i);
                if (f > 0) {
                    pq.add(f);
                }
            }

            // If heap is empty, add only processed tasks, otherwise add n + 1
            if (pq.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }
        }
        return time;
    }
}
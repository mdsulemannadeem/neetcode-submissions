class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
for(int i = 0; i < tasks.length; i++) freq[tasks[i] - 'A']++;

PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
for(int i = 0; i < 26; i++) if(freq[i] > 0) maxHeap.offer(freq[i]);

Queue<int[]> cooldown = new LinkedList<>();      // {remainingCount, availableTime}
int time = 0;
while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
    time++;
    if(!maxHeap.isEmpty()){
        int cnt = maxHeap.poll() - 1;
        if(cnt > 0) cooldown.offer(new int[]{cnt, time + n});   // HOLD
    }
    if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
        maxHeap.offer(cooldown.poll()[0]);                      // RELEASE
    }
}
return time;
    }
}

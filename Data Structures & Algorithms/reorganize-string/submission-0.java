class Solution {
    public String reorganizeString(String s) {

          int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);  // {char, freq}

// ... freq map banao, saare chars heap mein daalo
 // Saare valid chars heap mein daalein
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                maxHeap.offer(new int[]{(i + 'a'), counts[i]});
            }
        }

StringBuilder sb = new StringBuilder();
int[] prev = null;   // pichla use kiya hua char, jisko ek step rokna hai

while(!maxHeap.isEmpty()){
    int[] curr = maxHeap.poll();
    sb.append((char) curr[0]);
    curr[1]--;

    if(prev != null && prev[1] > 0){
        maxHeap.offer(prev);   // pichla wala wapas heap mein daal do (ab eligible hai)
    }
    prev = curr;   // current ko "cooldown" mein daal do
}
return sb.length() == s.length() ? sb.toString() : "";
    }
}
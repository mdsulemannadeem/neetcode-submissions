class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];                           // trust milne par +1, trust dene par -1
for(int i = 0; i < trust.length; i++){
    int u = trust[i][0];
    int v = trust[i][1];
    score[u]--;
    score[v]++;
}
for(int i = 1; i <= n; i++){
    if(score[i] == n - 1) return i;                     
}
return -1;
    }
}
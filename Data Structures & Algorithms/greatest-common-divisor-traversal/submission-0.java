class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        int maxNum = 0;
        for (int num : nums) {
            if (num == 1) return false; // 1 has no prime factors > 1, so it can never be connected
            maxNum = Math.max(maxNum, num);
        }

        // Smallest prime factor (SPF) sieve up to maxNum
        int[] spf = new int[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= maxNum; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxNum; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        // DSU with size `n + maxNum + 1` to link array indices and prime factors
        UnionFind uf = new UnionFind(n + maxNum + 1);
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp > 1) {
                int prime = spf[temp];
                uf.union(i, n + prime); // link index i with the prime factor node
                while (temp % prime == 0) {
                    temp /= prime;
                }
            }
        }

        // Check if all indices belong to a single connected component
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new  int[n]; // (or int[n])
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
        }
    }
}

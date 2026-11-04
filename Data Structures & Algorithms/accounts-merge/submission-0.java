class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        // Initialize the DSU parent array
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map to store: email -> first account index that owns it
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Step 1: Group accounts by merging their indices when they share emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    // Call the separate union function
                    union(i, emailToIndex.get(email), parent);
                }
            }
        }

        // Step 2: Collect emails under their respective absolute root parent
        Map<Integer, List<String>> mergedGroups = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int rootAccountIndex = find(entry.getValue(), parent);
            mergedGroups.computeIfAbsent(rootAccountIndex, x -> new ArrayList<>()).add(email);
        }

        // Step 3: Format the final output list
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedGroups.entrySet()) {
            int rootIndex = entry.getKey();
            List<String> emails = entry.getValue();
            
            Collections.sort(emails); // Requirements specify sorted emails

            List<String> formattedAccount = new ArrayList<>();
            formattedAccount.add(accounts.get(rootIndex).get(0)); // Get owner's name
            formattedAccount.addAll(emails);                     
            result.add(formattedAccount);
        }

        return result;
    }

    // Helper Function 1: Find with Path Compression
    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    // Helper Function 2: Union to connect two components
    private void union(int i, int j, int[] parent) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
                // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Group numbers by frequency using a HashSet
        List<HashSet<Integer>> frequencyGroups = new ArrayList<>();
        int maxFrequency = nums.length;
        for (int i = 0; i <= maxFrequency; i++) {
            frequencyGroups.add(new HashSet<>());
        }

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            frequencyGroups.get(freq).add(num);
        }

        // Step 3: Collect the top K frequent elements
        List<Integer> result = new ArrayList<>();
        for (int freq = maxFrequency; freq >= 0 && result.size() < k; freq--) {
            for (int num : frequencyGroups.get(freq)) {
                result.add(num);
                if (result.size() == k) break;
            }
        }

        // Convert the List<Integer> result to int[]
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;

    }
}

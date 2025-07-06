class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Record the frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create frequency array
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Store frequencies in the array of lists.
        // For example, if 3 and 2 are occuring 5 times, then freq[5] = (2, 3).
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // Retrieve the most frequent elements.
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
                if (index == k)
                    return res;
            }
        }

        return res;
    }
}

/**
Bucket Sort Solution
TC: O(N)
SC: O(N)
*/

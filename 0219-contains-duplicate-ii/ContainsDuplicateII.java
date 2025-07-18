
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // corner case
        if (nums == null || k <= 0 || nums.length == 0) return false; 

        // initilize sliding window
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            // add right
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // remove previous left
            if (right >= k + 1) {
                int prevLeft = right - k - 1;
                int numVals = map.get(nums[prevLeft]);
                if (numVals == 1) map.remove(nums[prevLeft]);
                else map.put(nums[prevLeft], numVals - 1);
            }

            // check any duplicate
            if (hasDuplicate(map, nums, right, k)) return true;
        }

        return false;
    }

    // Helper
    // O(1) TC to check if current step in loop creates any duplicate in the map
    private boolean hasDuplicate(Map<Integer, Integer> map, int[] nums, int right, int k) {
        // Check add right
        if (map.get(nums[right]) > 1) return true;

        // Check remove left
        if (right >= k + 1) {
            // Either we've removed nums[left] or reduced its occurrence.
            int numVal = map.getOrDefault(nums[right - k - 1], 0);
            if (numVal > 1) return true;
        }

        return false;
    }
}

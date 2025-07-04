class Solution {

    boolean isPossible(int maxSumAllowed, int[] nums, int k) {
        int subarraysNeeded = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (num > maxSumAllowed) return false;

            if (currentSum + num > maxSumAllowed) {
                subarraysNeeded++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return subarraysNeeded <= k;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, nums, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

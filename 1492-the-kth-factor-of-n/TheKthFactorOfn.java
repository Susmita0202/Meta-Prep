class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;

        // Check all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // If i divides n completely, it is a factor
            if (n % i == 0) {
                count++;   // found one factor

                // If this is the k-th factor, return it
                if (count == k) {
                    return i;
                }
            }
        }

        // If n has less than k factors
        return -1;
    }
}

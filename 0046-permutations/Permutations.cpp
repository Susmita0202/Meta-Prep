class Solution {
public:
    vector<int> nextGreaterPermutation(vector<int>& A) {
        int n = A.size();
        int ind = -1;

        // Step 1: Find pivot
        for (int i = n - 2; i >= 0; --i) {
            if (A[i] < A[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no pivot found, array is in descending order
        if (ind == -1) {
            reverse(A.begin(), A.end());
            return A;
        }

        // Step 2: Find element just larger than pivot and swap
        for (int j = n - 1; j > ind; --j) {
            if (A[j] > A[ind]) {
                swap(A[j], A[ind]);
                break;
            }
        }

        // Step 3: Reverse the suffix
        reverse(A.begin() + ind + 1, A.end());

        return A;
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;

        sort(nums.begin(), nums.end()); // Start with the smallest permutation
        ans.push_back(nums);

        // Compute total number of permutations: n!
        int total = 1;
        for (int i = 2; i <= nums.size(); ++i) {
            total *= i;
        }

        // Generate remaining permutations using nextGreaterPermutation
        for (int i = 1; i < total; ++i) {
            nums = nextGreaterPermutation(nums);
            ans.push_back(nums);
        }

        return ans;
    }
};

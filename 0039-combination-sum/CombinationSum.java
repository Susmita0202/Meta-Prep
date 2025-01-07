class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combination(candidates, target, 0, new ArrayList<>(), 0, ans);

        return ans;
    }

    private void combination(int[] candidates, int target, int idx, List<Integer> comb, int total,
            List<List<Integer>> ans) {
        if (total == target) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        if (total > target || idx >= candidates.length)
            return;

        comb.add(candidates[idx]);
        combination(candidates, target, idx, comb, total + candidates[idx], ans);

        comb.remove(comb.size() - 1);
        combination(candidates, target, idx + 1, comb, total, ans);
    }
}

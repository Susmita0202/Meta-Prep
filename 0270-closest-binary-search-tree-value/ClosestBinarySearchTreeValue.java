class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            // Update closest value
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
               (Math.abs(root.val - target) == Math.abs(closest - target)
                        && root.val < closest)) {
                closest = root.val;
            }

            // Move according to BST property
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}

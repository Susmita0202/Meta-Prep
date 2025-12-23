class Solution {

    // Helper class to store subtree information
    class Info {
        boolean isBST;
        int size;
        int min, max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        postOrder(root);
        return maxSize;
    }

    private Info postOrder(TreeNode root) {
        // Base case: empty tree is a BST
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = postOrder(root.left);
        Info right = postOrder(root.right);

        // Check BST property
        if (left.isBST && right.isBST &&
            root.val > left.max && root.val < right.min) {

            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);

            int minVal = Math.min(root.val, left.min);
            int maxVal = Math.max(root.val, right.max);

            return new Info(true, size, minVal, maxVal);
        }

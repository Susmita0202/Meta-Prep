class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val < root.val) {
                // Potential successor found
                successor = root;
                root = root.left;
            } else {
                // Move right if p >= root.val
                root = root.right;
            }
        }

        return successor;
    }
}

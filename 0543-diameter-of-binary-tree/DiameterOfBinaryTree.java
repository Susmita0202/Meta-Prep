class Solution {
    private int maxDia = 0;

    private int heightAndDiameter(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = heightAndDiameter(root.left);
        int rightHeight = heightAndDiameter(root.right);

        // Update the maximum diameter found so far
        maxDia = Math.max(maxDia, leftHeight + rightHeight);
        
        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0; 
        heightAndDiameter(root);
        return maxDia;
    }
}

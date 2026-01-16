class Solution {

    // Pointers to track the first (smallest) and last (largest) nodes
    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        inorder(root);

        // Make the doubly linked list circular
        first.left = last;
        last.right = first;

        return first;
    }

    // Inorder traversal
    private void inorder(Node node) {
        if (node == null) return;

        // Left subtree
        inorder(node.left);

        // Link previous node (last) with current node
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            // First node (smallest)
            first = node;
        }

        last = node;

        // Right subtree
        inorder(node.right);
    }
}

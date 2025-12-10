/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return root;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize=queue.size();
            for(int i=0;i<levelsize;i++){
                Node cnode=queue.poll();
                if(i!=levelsize-1)cnode.next=queue.peek();
                else cnode.next=null;
                if(cnode.left!=null)queue.offer(cnode.left);
                if(cnode.right!=null)queue.offer(cnode.right);
            }
        }
        return root;
    }
}

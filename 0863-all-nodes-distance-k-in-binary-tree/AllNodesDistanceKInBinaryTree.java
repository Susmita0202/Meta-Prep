/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // Step 1: Map each node to its parent
    public void findParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode curr = que.poll();

            if (curr.left != null) {
                map.put(curr.left, curr);
                que.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                que.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(root, parentMap);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        // Step 2: BFS until distance K
        while (!que.isEmpty()) {
            int size = que.size();
            if (currLevel == k) break;

            currLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    que.offer(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && visited.get(curr.right) == null) {
                    que.offer(curr.right);
                    visited.put(curr.right, true);
                }

                if (parentMap.get(curr) != null && visited.get(parentMap.get(curr)) == null) {
                    que.offer(parentMap.get(curr));
                    visited.put(parentMap.get(curr), true);
                }
            }
        }

        // Step 3: Collect nodes at distance K
        List<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            ans.add(que.poll().val);
        }
        return ans;
    }
}

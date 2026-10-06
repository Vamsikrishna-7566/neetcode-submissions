/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        DFS(result, root, 0);
        return result;
    }

    public void DFS(List<Integer> result, TreeNode root, int depth){

        if(root == null) return;
        if(depth == result.size()) {
            result.add(root.val);
        }

        DFS(result, root.right, depth+1);

        DFS(result, root.left, depth+1);


    }
}

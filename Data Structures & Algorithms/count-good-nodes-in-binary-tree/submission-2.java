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
    public int goodNodes(TreeNode root) {
        return DFS(root, root.val);
    }

    public int DFS(TreeNode root, int maxValue){
        if(root == null){
            return 0 ;
        }

        int result = 0;
        if(root.val >= maxValue){
            result++;
        }

        maxValue = Math.max(maxValue, root.val);
        
        result = result + DFS(root.left, maxValue);
        result = result + DFS(root.right, maxValue);

        return result;
    }
}

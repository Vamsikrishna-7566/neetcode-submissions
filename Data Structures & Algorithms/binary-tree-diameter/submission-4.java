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
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        DFS(root);
        return diameter;
    }

    public int DFS(TreeNode root){
        if(root == null) return 0;

        int left = DFS(root.left);
        int right = DFS(root.right);

        diameter = Math.max(diameter, left+right);
        return 1+Math.max(left, right);

    }
}

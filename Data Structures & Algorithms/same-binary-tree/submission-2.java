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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // at any point of time if the value does not match. return false.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();

            if(temp1 == null && temp2 == null){
                continue;
            }

            if(temp1 == null || temp2 == null){
                return false;
            }

            if(temp1.val != temp2.val) return false;

            queue.offer(temp1.left);
            queue.offer(temp2.left);
            queue.offer(temp1.right);
            queue.offer(temp2.right);
            
        }

        return true;

    }
}

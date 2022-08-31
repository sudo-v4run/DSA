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
    int minDist = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        minDiffInBSTUtil(root);
        return minDist;
    }
    public void minDiffInBSTUtil(TreeNode root) {
        if(root==null){
            return;
        }
        minDiffInBST(root.left);
        if(prev<root.val)
            minDist = Math.min(minDist,(root.val-prev));
        prev = root.val;
        minDiffInBST(root.right);
    }
}
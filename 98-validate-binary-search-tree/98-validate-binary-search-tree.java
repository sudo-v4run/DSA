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
    public boolean isValidBST(TreeNode root) {
        
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    public static boolean f(TreeNode root,long left,long right){
        
        if(root==null)
            return true;
        
        if(root.val<=left || root.val>=right)
            return false;
        
        boolean leftBST = f(root.left,left,root.val);
        boolean rightBST = f(root.right,root.val,right);
        
        return (leftBST&&rightBST);
        
    }
}
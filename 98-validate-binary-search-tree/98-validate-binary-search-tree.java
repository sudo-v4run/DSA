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
    // TreeNode pre = null;
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (!isValidBST(root.left)) return false;
    //     if (pre != null && pre.val >= root.val) return false;
    //     pre = root;
    //     return isValidBST(root.right);
    // }
    
    static  TreeNode prev;
     
    static boolean isBSTUtil(TreeNode root)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null)
        {
            if (!isBSTUtil(root.left))
                return false;
     
            // Allows only distinct valued nodes
            if (prev != null && root.val <= prev.val)
                return false;
     
            prev = root;
     
            return isBSTUtil(root.right);
        }
        return true;
    }
     
    public boolean isValidBST(TreeNode root) {
        prev=null;
        return isBSTUtil(root);
    }
}
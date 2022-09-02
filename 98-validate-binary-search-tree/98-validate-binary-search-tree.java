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
        
        return isValidBSTUtil(root,Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    public static boolean isValidBSTUtil(TreeNode root,long minVal,long maxVal){
        if(root==null)
            return true;
        
        if(root.val<=minVal || root.val >=maxVal)
            return false;
        
        return isValidBSTUtil(root.left,minVal,root.val)
            && isValidBSTUtil(root.right,root.val,maxVal);
    }
    
    
    
    
    
    // TreeNode pre = null;
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (!isValidBST(root.left)) return false;
    //     if (pre != null && pre.val >= root.val) return false;
    //     pre = root;
    //     return isValidBST(root.right);
    // }
    
    
    
    
    
    
    
//     static  TreeNode prev;
     
//     static boolean isBSTUtil(TreeNode root)
//     {
//         if (root != null)
//         {
//             if (!isBSTUtil(root.left))
//                 return false;
     
//             if (prev != null && root.val <= prev.val)
//                 return false;
     
//             prev = root;
     
//             return isBSTUtil(root.right);
//         }
//         return true;
//     }
     
//     public boolean isValidBST(TreeNode root) {
//         prev=null;
//         return isBSTUtil(root);
//     }
}
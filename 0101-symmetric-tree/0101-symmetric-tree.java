
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return isSymmtrc(root.left,root.right);
    }
    public static boolean isSymmtrc(TreeNode left, TreeNode right){
        
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        if(left.val!=right.val)
            return false;
        
        return isSymmtrc(left.left,right.right) 
               && isSymmtrc(left.right,right.left);
    }
}
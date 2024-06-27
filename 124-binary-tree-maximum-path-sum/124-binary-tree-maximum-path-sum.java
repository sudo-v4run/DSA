
class Solution {
    static int max;
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        
        f(root);
        
        return max;
    }
    public int f(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int left = f(root.left);
        int right = f(root.right);
        
        left = Math.max(left,0);
        right = Math.max(right,0);
        
        int cur = left+root.val+right;
        
        max = Math.max(max,cur);
        
        return root.val + Math.max(left,right);
    }
}
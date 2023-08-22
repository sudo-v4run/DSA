class Solution {
    
    static int max;
    
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        
        maxPath(root);
        
        return max;
    }
    public static int maxPath(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int left = Math.max(0,maxPath(root.left));
        int right = Math.max(0,maxPath(root.right));
        
        max = Math.max(max,left+root.val+right);
        
        return root.val + Math.max(left,right);
    }
}
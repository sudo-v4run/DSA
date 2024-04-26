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
            minDist = Math.min(minDist,root.val-prev);
        prev = root.val;
        
        minDiffInBST(root.right);
    }
}
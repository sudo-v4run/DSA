class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxPath(root,ans);
        return ans[0];
    }
    public static int maxPath(TreeNode root,int ans[]){
        if(root==null){
            return 0;
        }
        
        int left = Math.max(0,maxPath(root.left,ans));
        int right = Math.max(0,maxPath(root.right,ans));
        
        ans[0] = Math.max(ans[0],left+root.val+right);
        
        return root.val + Math.max(left,right);
    }
}
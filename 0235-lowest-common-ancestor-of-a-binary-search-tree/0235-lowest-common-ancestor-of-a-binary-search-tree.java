class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        if(p.val < root.val && root.val < q.val){
            return root;
        }
        
        if(q.val < root.val && root.val < p.val){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        
        if(left != null){
            return left;
        }
        
        return lowestCommonAncestor(root.right,p,q);
    }
}
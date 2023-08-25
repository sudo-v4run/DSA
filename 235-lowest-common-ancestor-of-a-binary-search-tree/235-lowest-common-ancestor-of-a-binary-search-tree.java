class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        
        return root;
        
//         TreeNode cur = root;
        
//         while(cur != null){
            
//             if(p.val < cur.val && q.val < cur.val){
//                 cur = cur.left;
//             }else if(p.val > cur.val && q.val > cur.val){
//                 cur = cur.right;
//             }else{
//                 break;
//             }
//         }
        
//         return cur;
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null){
            return new TreeNode(val);
        }
        
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }else{
            root.right = insertIntoBST(root.right,val);
        }
        
        return root;
        
//         if(root == null){
//             return new TreeNode(val);
//         }
        
//         TreeNode cur = root, parent = null;
        
//         while(cur != null){
//             if(val < cur.val){
//                 parent = cur;
//                 cur = cur.left;
//             }else{
//                 parent = cur;
//                 cur = cur.right;
//             }
//         }
        
//         if(val > parent.val){
//             parent.right = new TreeNode(val);
//         }else{
//             parent.left = new TreeNode(val);
//         }
        
//         return root;
    }
}
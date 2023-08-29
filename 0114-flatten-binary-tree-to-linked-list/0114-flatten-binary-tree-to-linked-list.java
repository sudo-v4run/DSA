
class Solution {
    
    
    public void flatten(TreeNode root) {
        
//         if(root==null){
//             return;
//         }
        
//         flatten(root.left);
//         flatten(root.right);
        
//         TreeNode temp = root.right;
//         root.right = root.left;
//         root.left = null;
//         while(root.right!=null){
//             root = root.right;
//         }
//         root.right = temp;
        
        
        TreeNode cur = root;
        
        while(cur != null){
    
            if(cur.left!=null){
                TreeNode temp = cur.left;
                
                while(temp.right!=null){
                    temp = temp.right;
                }
                
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    
    
    
//     TreeNode prev = null;
    
//     public void flatten(TreeNode root) {
//         if(root==null){
//             return;
//         }
        
//         flatten(root.right);
//         flatten(root.left);
        
//         root.right = prev;
//         root.left = null;
        
//         prev = root;
        
//     }
}
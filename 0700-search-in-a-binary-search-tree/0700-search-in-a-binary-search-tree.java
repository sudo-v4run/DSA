
class Solution {
  
    public TreeNode searchBST(TreeNode root, int val) {
//         TreeNode cur = root;
        
//         while(cur!=null){
//             if(cur.val==val){
//                 return cur;
//             }else if(val>cur.val){
//                 cur = cur.right;
//             }else{
//                 cur = cur.left;
//             }
//         }
        
//         return null;
        
        if(root==null){
            return null;
        }
        
        if(root.val == val ){
            return root;
        }
        if(val>root.val){
            return searchBST(root.right,val);
        }
        return searchBST(root.left,val);
    }
}
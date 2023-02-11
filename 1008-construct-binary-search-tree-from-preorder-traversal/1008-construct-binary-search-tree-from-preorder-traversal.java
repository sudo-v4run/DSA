
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return f(0,preorder.length-1,preorder);
    }
    public static TreeNode f(int l, int r, int[] pre){
        if(l>r){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[l]);
        
        int i = l+1;
        for( ; i<=r ; i++){
            if(pre[i]>pre[l]){
                break;
            }
        }
        
        root.left = f(l+1,i-1,pre);
        root.right = f(i,r,pre);
        
        return root;
    }
}
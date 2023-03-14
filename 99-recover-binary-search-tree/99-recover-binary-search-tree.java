class Solution {
    
    static TreeNode prev,first, mid, second;
    
    public void recoverTree(TreeNode root) {
        
        prev = null;
        first = null;
        mid = null;
        second = null;
        
        inOrder(root);
        
        if(second != null){
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }else{
            int temp = mid.val;
            mid.val = first.val;
            first.val = temp;
        }
    }
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        
        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                mid = root;
            }else{
                second = root;
            }
        }
        prev = root;
        
        inOrder(root.right);
    }
}
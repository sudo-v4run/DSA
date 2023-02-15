class Solution {
    
    static TreeNode prev;
    static TreeNode first;
    static TreeNode mid;
    static TreeNode last;
    
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        first = mid = last = null;
        
        inOrder(root);
        
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null && mid != null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        
        if(root.val < prev.val){
            if(first == null){
                first = prev;
                mid = root;
            }else{
                last = root;
            }
        }
        
        prev = root;
        
        inOrder(root.right);
    }
}
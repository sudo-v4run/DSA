class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
        int diameter[] = new int[1];
        f(root,diameter);
        
        return diameter[0];
    }
    public static int f(TreeNode root, int diameter[]){
        
        if(root==null){
            return 0;
        }
        
        int left = f(root.left,diameter);
        int right = f(root.right,diameter);
        
        diameter[0] = Math.max(diameter[0],left+right);
        
        return 1 + Math.max(left,right);
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int lc = findLeftCompleteness(root);
        int rc = findRightCompleteness(root);
        
        if(lc==rc){
            return (1<<lc)-1; // no. of nodes in a perfect binary tree -> 2^h -1
        }
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public static int findLeftCompleteness(TreeNode root){
        int h = 0;
        
        while(root!=null){
            h++;
            root = root.left;
        }
        
        return h;
    }
    public static int findRightCompleteness(TreeNode root){
        int h = 0;
        
        while(root!=null){
            h++;
            root = root.right;
        }
        
        return h;
    }
}
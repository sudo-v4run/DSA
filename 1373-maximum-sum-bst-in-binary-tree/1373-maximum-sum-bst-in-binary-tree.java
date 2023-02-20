class Solution {
    static int ans;
    static class Node{
        int sum;
        int max;
        int min;
        
        Node(int sum, int max, int min){
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }
    public int maxSumBST(TreeNode root) {
        
        ans = 0;
        
        f(root);
        
        return ans;
    }
    public static Node f(TreeNode root){
        if(root == null){
            return new Node(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        
        Node left = f(root.left);
        Node right = f(root.right);
        
        if(left.max < root.val && root.val < right.min){
            ans = Math.max(ans,root.val+left.sum+right.sum);
            return new Node( root.val+left.sum+right.sum,
                             Math.max(root.val,right.max),
                             Math.min(root.val,left.min) );
        }
        
        return new Node( Math.max(left.sum,right.sum),
                         Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
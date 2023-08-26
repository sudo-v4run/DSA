
class Solution {
    
    class Tuple{
        int min,max,sum;
        
        Tuple(int min, int max, int sum){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    
    static int max;
    
    public int maxSumBST(TreeNode root) {
        
        max = 0;
        
        solve(root);
        
        return max;
    }
    public Tuple solve(TreeNode root){
        if(root == null){
            return new Tuple(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        
        Tuple left = solve(root.left);
        Tuple right = solve(root.right);
        
        if(!(root.val > left.max && root.val < right.min)){
            return new Tuple(Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        int newMin = Math.min(left.min,root.val);
        int newMax = Math.max(right.max,root.val);
        int newSum = left.sum + root.val + right.sum;
        max = Math.max(max,newSum);
        
        return new Tuple(newMin,newMax,newSum);
    }
}
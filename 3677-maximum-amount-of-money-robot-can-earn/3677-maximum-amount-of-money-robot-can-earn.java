class Solution {
    private int helper(int [][]array, int i, int j, int n,Integer[][][] dp){
        if(i>=array.length||j>=array[0].length){
            return Integer.MIN_VALUE;
        }
        if(i==array.length-1&&j==array[0].length-1){
            if(array[i][j]<0){
                return n>0?0:array[i][j];
            }else{
                return array[i][j];
            }
        }
        if (dp[i][j][n] != null) {
            return dp[i][j][n];
        }
        int value=array[i][j];
        int max=Math.max(helper(array,i+1,j,n,dp),helper(array,i,j+1,n,dp));

        int use=Integer.MIN_VALUE;
        int waste=Integer.MIN_VALUE;
        if(value<0){
            if(n>0){
                use=Math.max(helper(array,i+1,j,n-1,dp),helper(array,i,j+1,n-1,dp));
            }
            waste=max-Math.abs(value);
        }
        dp[i][j][n]= Math.max(max+value,Math.max(use,waste));
        return dp[i][j][n];
    }
    public int maximumAmount(int[][] array) {
        Integer[][][] dp = new Integer[array.length][array[0].length][3]; // Memoization
        return helper(array,0,0,2,dp);
    }
}
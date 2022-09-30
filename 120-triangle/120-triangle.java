class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        
        // Memoization ...
        
        int dp[][] = new int[arr.size()][arr.get(arr.size()-1).size()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return tmps(0,0,arr,dp);
    }
    public static int tmps(int i,int j , List<List<Integer>> arr,int dp[][]){
        
        if(i==arr.size()-1){
            return arr.get(arr.size()-1).get(j);
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        int down = arr.get(i).get(j)+tmps(i+1,j,arr,dp);
        int dg = arr.get(i).get(j)+tmps(i+1,j+1,arr,dp);
        
        return dp[i][j] = Math.min(down,dg);
        
        
        
        
        
        // Only Recursion
//         if(i==arr.size()-1){
//             return arr.get(arr.size()-1).get(j);
//         }
//         int down = arr.get(i).get(j)+tmps(i+1,j,arr);
//         int dg = arr.get(i).get(j)+tmps(i+1,j+1,arr);
        
//         return Math.min(down,dg);
    }
}
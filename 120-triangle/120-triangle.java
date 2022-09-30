class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        
        int m = arr.size();
        int n = arr.get(arr.size()-1).size();
        
        // Memoization ...
        
//         int dp[][] = new int[m][n];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return tmps(0,0,arr,dp);
        
        
        // Tabulation ....
       
//         int dp[][] = new int[m][n];
        
//         for(int j =0 ; j < n ; j++ ){
//             dp[m-1][j] = arr.get(m-1).get(j);
//         }
        
//         for(int i = m-2 ; i >= 0 ; i--){
//             int N = arr.get(i).size();
//             for(int j = N-1 ; j>=0 ; j--){
//                 int down = arr.get(i).get(j)+dp[i+1][j];
//                 int dg = arr.get(i).get(j)+dp[i+1][j+1];
//                 dp[i][j] = Math.min(down,dg);
//             }
//         }
        
//        return dp[0][0];
        
        // Tabulation ...Space Optimized ..
        
        
        int cur[] = new int[n];
        int next[] = new int[n];
        
        for(int j =0 ; j < n ; j++ ){
            next[j] = arr.get(m-1).get(j);
        }
        
        for(int i = m-2 ; i >= 0 ; i--){
            int N = arr.get(i).size();
            for(int j = N-1 ; j>=0 ; j--){
                int down = arr.get(i).get(j)+next[j];
                int dg = arr.get(i).get(j)+next[j+1];
                cur[j] = Math.min(down,dg);
            }
            next = cur.clone();
        }
        
        return next[0];
        
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
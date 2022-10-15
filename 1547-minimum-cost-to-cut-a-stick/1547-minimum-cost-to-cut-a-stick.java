class Solution {
    public int minCost(int len, int[] cuts) {
        int n = cuts.length;
        int cutsarr[] = new int[n+2];
        cutsarr[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            cutsarr[i] = cuts[i-1];
        }
        cutsarr[n+1] = len;
        
        Arrays.sort(cutsarr);
        
        
        
        
        
        //Memoization...
        int dp[][] = new int[n+2][n+2];
        
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        return mctcs(1,n,cutsarr,dp);
    }
    public static int mctcs(int i,int j,int cutsarr[],int dp[][]){
        
        if(i>j){
            return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        
        for(int index = i ; index <= j ; index++){
            int cost = cutsarr[j+1]-cutsarr[i-1] +
                    mctcs(i,index-1,cutsarr,dp)+mctcs(index+1,j,cutsarr,dp);
            mini = Math.min(mini,cost);
        }
        
        return dp[i][j] = mini;
        
        
        // Recursion...
        
        
//         if(i>j){
//             return 0;
//         }
        
//         int mini = Integer.MAX_VALUE;
        
//         for(int index = i ; index <= j ; index++){
//             int cost = cutsarr[j+1]-cutsarr[i-1] +
//                     mctcs(i,index-1,cutsarr)+mctcs(index+1,j,cutsarr);
//             mini = Math.min(mini,cost);
//         }
        
//         return mini;
    }
}
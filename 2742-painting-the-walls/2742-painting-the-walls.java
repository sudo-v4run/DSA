class Solution {
    public int paintWalls(int[] cost, int[] time) {
        
        int n = cost.length;
        
        int dp[][] = new int[n+1][n+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,n,cost,time,dp);
    }
    public static int f(int i, int wallsRemaining, int cost[], int time[], int dp[][]){
        
        if(wallsRemaining <= 0){
            return 0;
        }
        
        if(i == cost.length){
            return (int)1e9;
        }
        
        if(dp[i][wallsRemaining] != -1){
            return dp[i][wallsRemaining];
        }
        
        int take = cost[i] + f(i+1,wallsRemaining-1-time[i],cost,time,dp);
        int notTake = f(i+1,wallsRemaining,cost,time,dp);
        
        return dp[i][wallsRemaining] = Math.min(take,notTake);
    }
}
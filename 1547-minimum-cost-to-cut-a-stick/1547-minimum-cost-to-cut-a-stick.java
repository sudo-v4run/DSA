class Solution {
    public int minCost(int n, int[] cuts) {
        
        int arr[] = new int[cuts.length+2];
        
        arr[0] = 0;
        arr[arr.length-1] = n;
        int k = 1;
        for(int c : cuts){
            arr[k++] = c;
        }
        
        Arrays.sort(arr);
        
        int dp[][] = new int[arr.length][arr.length];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(1,arr.length-2,arr,dp);
    }
    public static int f(int i, int j, int arr[], int dp[][]){
        
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int k = i ; k <= j ; k++){
            
            int cost = arr[j+1] - arr[i-1] + f(i,k-1,arr,dp) + f(k+1,j,arr,dp);
            
            mini = Math.min(mini,cost);
        }
        
        return dp[i][j] = mini;
    }
}
class Solution {
    public int maxCoins(int[] nums) {
        
//         int n = nums.length;
//         int arr[] = new int[n+2];
//         arr[0] = 1;
//         arr[n+1] = 1;
//         for(int i = 1 ; i <= n ; i++){
//             arr[i] = nums[i-1];
//         }
        
//         //Tabulation....
        
//         int dp[][] = new int[n+2][n+2];
        
//         for(int i = n ; i >= 1 ; i--){
//             for(int j = 1 ; j <= n ; j++){
                
//                 if(i>j)
//                     continue;               
                
//                 int maxi = Integer.MIN_VALUE;
        
//                 for(int index = i ; index<=j ; index++){
//                     int coins = arr[index]*arr[i-1]*arr[j+1]+
//                                     dp[i][index-1]+dp[index+1][j];
//                     maxi = Math.max(maxi,coins);
//                 }

//                 dp[i][j] = maxi;
//             }
//         }
        
//         return dp[1][n];
        
        
        
        // Memoization....
        
        int n = nums.length;
        
        int dp[][] = new int[n][n];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,n-1,nums,dp);
    }
    public static int f(int i, int j, int arr[], int dp[][]){
        
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int max = 0;
        
        for(int k = i ; k <= j ; k++){
            
            int left = 1;
            if(i-1 >= 0){
                left = arr[i-1];
            }
            
            int right = 1;
            if(j+1 <= arr.length-1){
                right = arr[j+1];
            }
            
            int coins = left*arr[k]*right + f(i,k-1,arr,dp) + f(k+1,j,arr,dp);
                // we go from last bolloon bursted to frist balloon bursted..
            
            max = Math.max(max,coins);
        }
        
        return dp[i][j] = max;
    }
}
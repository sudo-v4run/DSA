class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 1 ; i <= n ; i++){
            arr[i] = nums[i-1];
        }
        
        
        //Memoization...
        
        int dp[][] = new int[n+2][n+2];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        return fbb(1,n,arr,dp);
    }
    public static int fbb(int i , int j , int arr[],int dp[][]){
        
        if(i>j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int maxi = Integer.MIN_VALUE;
        
        for(int index = i ; index<=j ; index++){
            int coins = arr[index]*arr[i-1]*arr[j+1]+
                            fbb(i,index-1,arr,dp)+fbb(index+1,j,arr,dp);
            maxi = Math.max(maxi,coins);
        }
        
        return dp[i][j] = maxi;
        
        
        
        // Recursion....
        
//         if(i>j)
//             return 0;
        
//         int maxi = Integer.MIN_VALUE;
        
//         for(int index = i ; index<=j ; index++){
//             int coins = arr[index]*arr[i-1]*arr[j+1]+
//                             fbb(i,index-1,arr)+fbb(index+1,j,arr);
//             maxi = Math.max(maxi,coins);
//         }
        
//         return maxi;
    }
}
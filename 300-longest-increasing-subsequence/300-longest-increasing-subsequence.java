class Solution {
    public int lengthOfLIS(int[] arr) {
        
        int n = arr.length;
        
        // Memoization ... Top Down...
        
        int dp[][] = new int[n][n+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,-1,arr,dp);
    }
    public static int f(int index, int prevInd , int arr[],int dp[][]){
        
        if(index==arr.length){
            return 0;
        }
        
        if(dp[index][prevInd+1] != -1){
            return dp[index][prevInd+1];
        }
        
        int take = 0;
        
        if(prevInd == -1 || arr[index]>arr[prevInd]){
            take = 1 + f(index+1,index,arr,dp);
        }
        
        int notTake = f(index+1,prevInd,arr,dp);
        
        return dp[index][prevInd+1] = Math.max(take,notTake);
        
        
        // Recursion...
        
//         if(index>=arr.length){
//             return 0;
//         }
        
//         int maxLen = 0;
        
//         int take = 0;
            
//         if(arr[index]>last){
//             take = 1 + f(index+1,arr[index],arr);
//         }
        
//         int notTake = f(index+1,last,arr);
        
//         maxLen = Math.max(take,notTake);
        
//         return maxLen;
    }
}
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        
        // Tabulation ..
        int dp[] = new int[n+1];
        
        for(int i = n-1 ; i>=0 ; i--){
            int maxi = Integer.MIN_VALUE;
            int maxEle = Integer.MIN_VALUE;
            for(int j = i ; j < Math.min(i+k,arr.length) ; j++){
                maxEle = Math.max(maxEle,arr[j]);
                int curSum = (j-i+1)*maxEle + dp[j+1];
                maxi = Math.max(maxi,curSum);
            }

            dp[i] = maxi;
        }
        
        
        return dp[0];
        
        // Memoization...
        
//         int dp[] = new int[n];
//         Arrays.fill(dp,-1);
        
//         return pawms(0,k,arr,dp);
    }
    public static int pawms(int i , int k,int arr[],int dp[]){
        
        if(i==arr.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int maxi = Integer.MIN_VALUE;
        int maxEle = Integer.MIN_VALUE;
        for(int j = i ; j < Math.min(i+k,arr.length) ; j++){
            maxEle = Math.max(maxEle,arr[j]);
            int curSum = (j-i+1)*maxEle + pawms(j+1,k,arr,dp);
            maxi = Math.max(maxi,curSum);
        }
        
        return dp[i] = maxi;
        
        
        
        // Recursion...
        
//         if(i==arr.length)
//             return 0;
        
//         int maxi = Integer.MIN_VALUE;
//         int maxEle = Integer.MIN_VALUE;
//         for(int j = i ; j < Math.min(i+k,arr.length) ; j++){
//             maxEle = Math.max(maxEle,arr[j]);
//             int curSum = (j-i+1)*maxEle + pawms(j+1,k,arr);
//             maxi = Math.max(maxi,curSum);
//         }
        
//         return maxi;
    }
}
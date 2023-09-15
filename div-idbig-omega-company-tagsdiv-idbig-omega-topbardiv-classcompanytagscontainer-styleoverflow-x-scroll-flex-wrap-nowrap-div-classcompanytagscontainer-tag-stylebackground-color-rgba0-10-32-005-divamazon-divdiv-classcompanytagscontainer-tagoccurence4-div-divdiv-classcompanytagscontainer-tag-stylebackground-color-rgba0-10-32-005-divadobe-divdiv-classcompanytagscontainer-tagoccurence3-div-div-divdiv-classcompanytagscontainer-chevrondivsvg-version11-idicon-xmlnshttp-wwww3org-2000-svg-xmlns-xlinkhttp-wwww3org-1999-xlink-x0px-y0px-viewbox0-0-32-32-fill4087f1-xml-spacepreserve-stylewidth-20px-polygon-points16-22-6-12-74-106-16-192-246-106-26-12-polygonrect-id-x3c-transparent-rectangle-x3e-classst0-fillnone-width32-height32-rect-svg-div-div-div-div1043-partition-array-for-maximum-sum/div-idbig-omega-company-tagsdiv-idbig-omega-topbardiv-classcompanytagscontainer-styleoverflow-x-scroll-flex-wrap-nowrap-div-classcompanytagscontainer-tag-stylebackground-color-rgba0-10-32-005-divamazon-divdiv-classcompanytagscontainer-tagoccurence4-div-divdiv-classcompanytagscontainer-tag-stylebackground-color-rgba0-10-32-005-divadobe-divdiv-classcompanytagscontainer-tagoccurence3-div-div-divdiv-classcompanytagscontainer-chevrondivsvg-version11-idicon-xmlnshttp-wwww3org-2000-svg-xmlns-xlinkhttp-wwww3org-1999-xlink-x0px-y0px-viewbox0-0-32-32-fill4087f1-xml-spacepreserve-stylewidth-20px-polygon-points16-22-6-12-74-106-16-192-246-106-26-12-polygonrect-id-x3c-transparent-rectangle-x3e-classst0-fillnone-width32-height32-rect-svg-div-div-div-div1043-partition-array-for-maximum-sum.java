class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        
        // Tabulation ..
        
//         int dp[] = new int[n+1];
        
//         for(int i = n-1 ; i>=0 ; i--){
//             int maxi = Integer.MIN_VALUE;
//             int maxEle = Integer.MIN_VALUE;
//             for(int j = i ; j < Math.min(i+k,arr.length) ; j++){
//                 maxEle = Math.max(maxEle,arr[j]);
//                 int curSum = (j-i+1)*maxEle + dp[j+1];
//                 maxi = Math.max(maxi,curSum);
//             }

//             dp[i] = maxi;
//         }
        
        
//         return dp[0];
        
        // Memoization...
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return f(0,k,arr,dp);
    }
    public static int f(int index, int k, int arr[], int dp[]){
        
        int n = arr.length;
        
        if(index == n){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int maxSum = 0;
        int maxEle = 0;
        int len = 0;
        for(int j = index ; j < n && j < index+k ; j++){
            len++;
            maxEle = Math.max(maxEle,arr[j]);
            int sum = len*maxEle + f(j+1,k,arr,dp);
            
            maxSum = Math.max(maxSum,sum);
        }
        
        return dp[index] = maxSum;
    }
}
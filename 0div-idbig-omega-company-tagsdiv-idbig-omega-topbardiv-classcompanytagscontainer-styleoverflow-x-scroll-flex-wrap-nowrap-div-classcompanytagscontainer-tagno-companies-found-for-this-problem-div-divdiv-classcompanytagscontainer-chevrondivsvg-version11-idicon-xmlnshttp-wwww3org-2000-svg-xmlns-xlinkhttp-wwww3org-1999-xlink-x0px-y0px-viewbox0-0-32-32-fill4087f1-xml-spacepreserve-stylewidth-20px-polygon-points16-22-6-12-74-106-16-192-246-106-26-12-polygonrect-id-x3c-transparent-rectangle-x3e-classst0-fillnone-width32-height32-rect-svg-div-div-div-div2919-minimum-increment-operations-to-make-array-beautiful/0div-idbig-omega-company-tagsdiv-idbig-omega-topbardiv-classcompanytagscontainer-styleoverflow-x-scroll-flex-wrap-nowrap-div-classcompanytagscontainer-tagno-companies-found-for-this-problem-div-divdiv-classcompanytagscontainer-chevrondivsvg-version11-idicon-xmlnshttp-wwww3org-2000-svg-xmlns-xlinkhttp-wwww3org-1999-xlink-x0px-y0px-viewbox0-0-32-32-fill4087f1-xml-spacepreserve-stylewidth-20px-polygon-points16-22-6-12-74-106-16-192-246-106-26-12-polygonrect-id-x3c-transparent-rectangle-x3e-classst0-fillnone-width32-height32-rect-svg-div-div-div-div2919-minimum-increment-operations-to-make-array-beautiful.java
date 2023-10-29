class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        
        int n = nums.length;
        
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        
        return f(0,k,nums,dp);
    }
    public long f(int index, int k, int arr[], long dp[]){
        
        int n = arr.length;
        
        if(index > n-3){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        long ans = Long.MAX_VALUE;
        for(int i = index ; i < index+3 && i < n; i++){
            long cur = Math.max(0,k-arr[i]) + f(i+1,k,arr,dp);
            ans = Math.min(ans,cur);
        }
        
        return dp[index] = ans;
    }
}
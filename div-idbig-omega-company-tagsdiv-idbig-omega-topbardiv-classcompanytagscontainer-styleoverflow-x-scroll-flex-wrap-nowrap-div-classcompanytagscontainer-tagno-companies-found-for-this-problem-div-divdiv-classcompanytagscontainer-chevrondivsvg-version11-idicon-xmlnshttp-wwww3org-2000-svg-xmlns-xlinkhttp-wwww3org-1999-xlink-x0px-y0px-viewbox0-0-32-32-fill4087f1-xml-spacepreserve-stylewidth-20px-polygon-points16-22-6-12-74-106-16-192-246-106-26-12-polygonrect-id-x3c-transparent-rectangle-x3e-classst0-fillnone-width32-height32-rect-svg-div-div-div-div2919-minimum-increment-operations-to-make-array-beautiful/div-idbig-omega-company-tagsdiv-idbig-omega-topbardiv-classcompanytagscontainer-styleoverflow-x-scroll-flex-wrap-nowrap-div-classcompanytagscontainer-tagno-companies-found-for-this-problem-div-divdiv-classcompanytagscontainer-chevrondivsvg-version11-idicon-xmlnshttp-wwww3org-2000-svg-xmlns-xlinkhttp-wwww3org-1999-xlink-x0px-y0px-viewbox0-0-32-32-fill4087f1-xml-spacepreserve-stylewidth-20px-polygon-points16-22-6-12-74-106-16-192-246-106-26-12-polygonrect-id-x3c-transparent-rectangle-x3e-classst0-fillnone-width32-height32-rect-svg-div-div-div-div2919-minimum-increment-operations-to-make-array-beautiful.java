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
        
        long cur1 = Math.max(0,k-arr[index]) + f(index+1,k,arr,dp);
        long cur2 = Math.max(0,k-arr[index+1]) + f(index+2,k,arr,dp);
        long cur3 = Math.max(0,k-arr[index+2]) + f(index+3,k,arr,dp);
        
        return dp[index] = Math.min(cur1,Math.min(cur2,cur3));
    }
}
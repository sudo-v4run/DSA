class Solution {
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;
        
        int sum = 0;
        
        for(int ele : nums){
            sum += ele;
        }
        
        if(sum%2 != 0){
            return false;
        }
        
        int k = sum/2;
        
        int dp[][] = new int[n][k+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,k,nums,dp);
    }
    public static boolean f(int index, int target, int arr[], int dp[][]){
        
        if(target == 0){
            return true;
        }
        
        if(target < 0){
            return false;
        }
        
        if(index >= arr.length){
            return false;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }
        
        boolean take = f(index+1,target-arr[index],arr,dp);
        boolean notTake = f(index+1,target,arr,dp);
        
        dp[index][target] = take || notTake ? 1 : 0;
        
        return take || notTake;
    }
}
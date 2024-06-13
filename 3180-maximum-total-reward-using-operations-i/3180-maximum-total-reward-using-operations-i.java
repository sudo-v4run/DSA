class Solution {
    public int maxTotalReward(int[] arr) {
        
        // Lets say the last element we picked is X.
        // The max possible value of reward before that is X-1.
        // This implies max possible reward is X + (X-1) = 2*X-1.
        // Since max value of X is 2000, so the max value of reward is 3999.
        
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int dp[][] = new int[n][4000];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,0,arr,dp);
    }
    public int f(int index, int curReward, int arr[], int dp[][]){
        
        int n = arr.length;
        
        if(index == n){
            return curReward;
        }
        
        if(dp[index][curReward] != -1){
            return dp[index][curReward];
        }
        
        int take = 0;
        if(arr[index] > curReward){
            take = f(index+1,curReward+arr[index],arr,dp);
        }
        
        int notTake = f(index+1,curReward,arr,dp);
        
        int ans = Math.max(take,notTake);
        
        return dp[index][curReward] = ans;
    }
}
class Solution {
    
    static int target;
    
    public int maximumJumps(int[] arr, int targett) {
    
        target = targett;
        int n = arr.length;
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        int ans = f(0,arr,dp);
        
        if(ans < 0){
            return -1;
        }
        return ans;
    }
    public static int f(int i, int arr[],int dp[]){
        
        int n = arr.length;
        
        if(i == n-1){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int j = i+1 ; j < n ; j++){
            
            if(-target <= (arr[j] - arr[i]) && (arr[j] - arr[i]) <= target){
                ans = Math.max(ans,1+f(j,arr,dp));
            }
        }
        
        return dp[i] = ans;
    }
}
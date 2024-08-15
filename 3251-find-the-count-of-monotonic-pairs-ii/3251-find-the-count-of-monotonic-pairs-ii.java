class Solution {
    static int mod;
    public int countOfPairs(int[] arr) {
        
        mod = (int)1e9+7;
        
        int n = arr.length;
        
        int dp[][] = new int[n+1][1001];
        
        for(int prev1 = 1000 ; prev1 >= 0 ; prev1--){
            dp[n][prev1] = 1;
        }
        
        for(int index = n-1 ; index >= 0 ; index--){
            
            int prefix[] = new int[1001];
            prefix[0] = dp[index+1][0];
            for(int i = 1 ; i <= 1000 ; i++){
                prefix[i] = (prefix[i-1] + dp[index+1][i])%mod;
            }
            
            
            for(int prev1 = 1000 ; prev1 >= 0 ; prev1--){
                
                int ans = 0;
                int prev2 = index==0 ? 1002 : (arr[index-1]-prev1);
                
                int l = Math.max(arr[index]-prev2,prev1);
                 // derived from the condition that prev2 should be >= curSecond
                
                int r = arr[index];
                
                if(l <= r){
                    int cur = prefix[r];
                    if(l > 0){
                        cur = (prefix[r] - prefix[l-1] + mod)%mod;
                    }

                    ans = (ans + cur)%mod;
                }
                dp[index][prev1] = ans%mod;
            }
        }
        
        return dp[0][0]%mod;
    }
}
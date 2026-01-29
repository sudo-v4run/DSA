class Solution {
    int dp[];
    public int countNumbersWithUniqueDigits(int n) {
        
        int ans = 0;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        for(int i = 0; i <= n ; i++){
            ans += f(i);
        }
        
        return ans;
    }
    public int f(int n){

        if(n > 10){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 9;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = f(n-1)*(10 - (n-1));
    }
}
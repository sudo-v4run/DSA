class Solution {
    public int getMoneyAmount(int n) {

        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        
        return f(1, n, dp);
    }
    public int f(int l, int h, int dp[][]){

        if(l >= h){
            return 0;
        }

        if(dp[l][h] != -1){
            return dp[l][h];
        }

        int ans = Integer.MAX_VALUE;

        for(int index = l; index <= h; index++){
            int left = index + f(l, index-1, dp);
            int right = index + f(index+1, h, dp);

            int cur = Math.max(left, right);

            ans = Math.min(ans, cur);
        }

        return dp[l][h] = ans;
    }
}
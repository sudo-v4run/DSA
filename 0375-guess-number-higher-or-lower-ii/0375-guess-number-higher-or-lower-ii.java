class Solution {
    static int preSum[];
    public int getMoneyAmount(int n) {

        preSum = new int[n+1];

        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        
        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i-1]+i;
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


        int t = (preSum[h]-preSum[l-1])/2;
        int ind = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = l; i <= h; i++){
            if(Math.abs(t-(preSum[i]-preSum[l-1])) < diff){
                ind = i;
                diff = Math.abs(t-(preSum[i]-preSum[l-1]));
            }
        }

        //System.out.println(preSum[h]+","+ind);


        for(int index = Math.max(l, ind - 99) ; index <= Math.min(h, ind + 99) ; index++){
            int left = index + f(l, index-1, dp);
            int right = index + f(index+1, h, dp);

            int cur = Math.max(left, right);

            ans = Math.min(ans, cur);
        }

        return dp[l][h] = ans;
    }
}
class Solution {
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        
        // Tabulation...Space Optimized....
        
        int cur[] = new int[2];
        int next[] = new int[2];
        
        for(int index = n-1 ; index>=0 ; index--){
            for(int canBuy = 0 ; canBuy<=1 ; canBuy++){
                if(canBuy==1){
                    cur[canBuy] = Math.max(next[0]-prices[index],
                                        next[1]-0);
                }else{
                    cur[canBuy] = Math.max(next[1]+prices[index]-fee,
                                        next[0]+0);
                }
            }
            next = cur.clone();
        }
        
        return next[1];
        
        
        
        // Tabulation...
        
//         int dp[][] = new int[n+2][2];
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int canBuy = 0 ; canBuy<=1 ; canBuy++){
//                 if(canBuy==1){
//                     dp[index][canBuy] = Math.max(dp[index+1][0]-prices[index],
//                                         dp[index+1][1]-0);
//                 }else{
//                     dp[index][canBuy] = Math.max(dp[index+1][1]+prices[index]-fee,
//                                         dp[index+1][0]+0);
//                 }
//             }
//         }
        
//         return dp[0][1];
        
        
        
        //Memoization...
        // int dp[][] = new int[n][2];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return bsswc(0,1,prices,fee,dp);
    }
    public static int bsswc(int index,int canBuy,int prices[],int fee,int dp[][]){
        
        if(index>=prices.length)
            return 0;
        
        if(dp[index][canBuy] != -1)
            return dp[index][canBuy];
        
        if(canBuy==1){
            return dp[index][canBuy] = Math.max(bsswc(index+1,0,prices,fee,dp)-prices[index],
                                bsswc(index+1,1,prices,fee,dp)-0);
        }else{
            return dp[index][canBuy] = Math.max(bsswc(index+1,1,prices,fee,dp)+prices[index]-fee,
                                bsswc(index+1,0,prices,fee,dp)+0);
        }
        
        
        
        
        //Recursion...
        
//         if(index>=prices.length)
//             return 0;
        
//         if(canBuy==1){
//             return Math.max(bsswc(index+1,0,prices)-prices[index],
//                                 bsswc(index+1,1,prices)-0);
//         }else{
//             return Math.max(bsswc(index+1,1,prices)+prices[index]-fee,
//                                 bsswc(index+1,0,prices)+0);
//         }
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int cap = 2;
        
        // Tabulation..(Buttom-Up)...Space Optimized..
        
        int limit = 2;
        
        int cur[][] = new int[2][3];
        int next[][] = new int[2][3];
        
        for(int index = n-1; index>=0 ; index--){
            for(int canBuy = 0 ; canBuy<=1 ; canBuy++){
                for(int cap = 1 ; cap<=2 ; cap++){
                    if(canBuy==1)
                        cur[canBuy][cap] = Math.max(next[0][cap]-prices[index],
                                               next[1][cap]-0 );
                    else
                        cur[canBuy][cap] = Math.max(next[1][cap-1]+prices[index],
                                                next[0][cap]+0 );
                }
            }
            for(int i = 0 ; i < cur.length ; i++){
                for(int j = 0 ; j < cur[0].length ; j++){
                    next[i][j] = cur[i][j];
                }
            }
        }
        
        
        return next[1][2];
        
        
        
        
        
        // Tabulation..(Buttom-Up)...
        
//         int limit = 2;
        
//         int dp[][][] = new int[n+1][2][3];
        
//         for(int index = n-1; index>=0 ; index--){
//             for(int canBuy = 0 ; canBuy<=1 ; canBuy++){
//                 for(int cap = 1 ; cap<=2 ; cap++){
//                     if(canBuy==1)
//                         dp[index][canBuy][cap] = Math.max(dp[index+1][0][cap]-prices[index],
//                                                 dp[index+1][1][cap]-0 );
//                     else
//                         dp[index][canBuy][cap] = Math.max(dp[index+1][1][cap-1]+prices[index],
//                                                 dp[index+1][0][cap]+0 );
//                 }
//             }
//         }
        
        
//         return dp[0][1][2];
        
        
        
        
        
        // Memoization..(Top-Down)...
        
//         int dp[][][] = new int[n][2][3];
//         for(int[][] ar1 : dp){
//             for(int[] ar2 : ar1){
//                 Arrays.fill(ar2,-1);
//             }
//         }
        
//         return bss3(0,1,cap,prices,dp);
    }
    public static int bss3(int index,int canBuy, int cap , int prices[],int dp[][][]){
        
        if(index==prices.length||cap==0){
            return 0;
        }
        
        if(dp[index][canBuy][cap] != -1){
            return dp[index][canBuy][cap];
        }
        
        if(canBuy==1){
            return dp[index][canBuy][cap] = Math.max(bss3(index+1,0,cap,prices,dp)-prices[index],
                                bss3(index+1,1,cap,prices,dp)-0 );
        }else{
            return dp[index][canBuy][cap] = Math.max(bss3(index+1,1,cap-1,prices,dp)+prices[index],
                                bss3(index+1,0,cap,prices,dp)+0 );
        }
        
        
        
        
        //Recursion....
        
//         if(index==prices.length||cap==0){
//             return 0;
//         }
        
//         if(canBuy==1){
//             return Math.max(bss3(index+1,0,cap,prices)-prices[index],
//                                 bss3(index+1,1,cap,prices)-0 );
//         }else{
//             return Math.max(bss3(index+1,1,cap-1,prices)+prices[index],
//                                 bss3(index+1,0,cap,prices)+0 );
//         }
        
    }
}
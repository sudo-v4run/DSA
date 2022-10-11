class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        
        // Memoization..(Top-Down)...
        
        int dp[][][] = new int[n][2][3];
        for(int[][] ar1 : dp){
            for(int[] ar2 : ar1){
                Arrays.fill(ar2,-1);
            }
        }
        
        return bss3(0,1,cap,prices,dp);
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
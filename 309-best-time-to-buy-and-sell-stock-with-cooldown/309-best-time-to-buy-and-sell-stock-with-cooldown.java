class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        //Memoization...
        int dp[][] = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return bsswc(0,1,prices,dp);
    }
    public static int bsswc(int index,int canBuy,int prices[],int dp[][]){
        
        if(index>=prices.length)
            return 0;
        
        if(dp[index][canBuy] != -1)
            return dp[index][canBuy];
        
        if(canBuy==1){
            return dp[index][canBuy] = Math.max(bsswc(index+1,0,prices,dp)-prices[index],
                                bsswc(index+1,1,prices,dp)-0);
        }else{
            return dp[index][canBuy] = Math.max(bsswc(index+2,1,prices,dp)+prices[index],
                                bsswc(index+1,0,prices,dp)+0);
        }
        
        
        
        
        //Recursion...
        
//         if(index>=prices.length)
//             return 0;
        
//         if(canBuy==1){
//             return Math.max(bsswc(index+1,0,prices)-prices[index],
//                                 bsswc(index+1,1,prices)-0);
//         }else{
//             return Math.max(bsswc(index+2,1,prices)+prices[index],
//                                 bsswc(index+1,0,prices)+0);
//         }
    }
}
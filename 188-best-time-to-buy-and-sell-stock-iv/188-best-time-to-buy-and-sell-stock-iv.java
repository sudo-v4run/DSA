class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        
        // Memoization...
        
        int dp[][] = new int[n][2*k];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return bss4(0,0,k,prices,dp);
    }
    public static int bss4(int index,int transaction,int k,int prices[],int dp[][]){
        
        if(index==prices.length||transaction==2*k)
            return 0;
        
        if(dp[index][transaction] != -1)
            return dp[index][transaction];
        
        if(transaction%2==0){
            return dp[index][transaction] = Math.max(
                                                bss4(index+1,transaction+1,k,prices,dp)-prices[index],
                                                bss4(index+1,transaction,k,prices,dp)-0     );
        }else{
            return dp[index][transaction] = Math.max(
                                                bss4(index+1,transaction+1,k,prices,dp)+prices[index],
                                                bss4(index+1,transaction,k,prices,dp)+0     );
        }
        
        
        
        // Recursion ...
        
//         if(index==prices.length||transaction==2*k)
//             return 0;
        
//         if(transaction%2==0){
//             return Math.max(bss4(index+1,transaction+1,k,prices)-prices[index],
//                                 bss4(index+1,transaction,k,prices)-0);
//         }else{
//             return Math.max(bss4(index+1,transaction+1,k,prices)+prices[index],
//                                 bss4(index+1,transaction,k,prices)+0);
//         }
    }
}
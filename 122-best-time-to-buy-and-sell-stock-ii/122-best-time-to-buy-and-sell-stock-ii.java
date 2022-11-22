class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;
        
        for(int i = 1; i < n ; i++){
            if(prices[i]>prices[i-1]){
                maxP += prices[i]-prices[i-1];
            }
        }
        
        return maxP;
        
    }
    static int maxP = 0;
    public static int f(int index,int canBuy,int prices[]){
        if(index>=prices.length)
            return 0;
        
        if(canBuy==1){
            maxP = Math.max(f(index+1,0,prices)-prices[index],
                            f(index+1,1,prices));
        }else{
            maxP = Math.max(f(index+1,1,prices)+prices[index],
                            f(index+1,0,prices));
        }
        
        return maxP;
    }
}
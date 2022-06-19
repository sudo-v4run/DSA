class Solution {
    public int maxProfit(int[] arr) {
        int profit = 0;
        int minSofar = arr[0];
        
        for(int i = 0 ; i <arr.length ; i++){
            minSofar = Math.min(minSofar,arr[i]);
            
            profit = Math.max(profit,arr[i]-minSofar);
        }
        
        return profit;
    }
}
class Solution {
    public int maxProfit(int[] arr) {
        int profit = 0;
        int minSofar = arr[0];
        
        for(int i = 0 ; i <arr.length ; i++){
            minSofar = Math.min(minSofar,arr[i]);
            
            profit = Math.max(profit,arr[i]-minSofar);
        }
        
        return profit;
        
//         int l = 0 ;
//         int r = 1;
//         int profit = 0;
//         int maxP = 0;
//         while(r<arr.length){
//             if(arr[l]<arr[r]){
//                 profit = arr[r] - arr[l];
//                 maxP = Math.max(maxP,profit);
//             }else{
//                 l = r;
//             }
//             r++;
//         }
        
//         return maxP;
    }
}
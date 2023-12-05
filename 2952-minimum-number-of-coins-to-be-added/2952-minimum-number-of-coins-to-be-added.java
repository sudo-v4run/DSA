class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        
        Arrays.sort(coins);
        
        int n = coins.length;
        int preSum = 0;
        int cnt = 0;
        int i = 0;
        
        for(int t = 1 ; t <= target ; t++){
            if(i < n && coins[i] <= t){
                preSum += coins[i];
                i++;
            }else{
                if(preSum >= t){
                    // t = preSum;  // for more optimization..
                    continue;
                }
                cnt++;
                preSum += t;
            }
        }
        
        return cnt;
    }
}
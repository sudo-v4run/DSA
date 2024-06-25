class Solution {
    public long maximumTotalCost(int[] arr) {
        
        int n = arr.length;
        
        long dp[][] = new long[n][2];
        
        for(long row[] : dp){
            Arrays.fill(row,Long.MIN_VALUE);
        }
        
        return f(0,1,arr,dp);
    }
    public long f(int index, int sign, int arr[], long dp[][]){
        
        int n = arr.length;
        
        if(index >= n){
            return 0;
        }
        
        if(dp[index][sign] != Long.MIN_VALUE){
            return dp[index][sign];
        }
        
        // split here...
        
        long split = 0;
        if(sign == 1){          // 1 -> + and  0 -> -
            split = arr[index] + f(index+1,1,arr,dp);
        }else{
            split = -arr[index] + f(index+1,1,arr,dp);
        }
        
        // do not split here...
        
        int newSign = sign == 1 ? 0 : 1;
        long notSplit = arr[index]*(sign) + f(index+1,newSign,arr,dp);
        
        return dp[index][sign] = Math.max(split,notSplit);
    }
}
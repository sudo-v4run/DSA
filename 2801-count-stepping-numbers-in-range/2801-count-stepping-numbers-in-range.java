class Solution {
    
    static long MOD = (long)1e9+7;
    
    public int countSteppingNumbers(String low, String high) {
        
        long dp[][][][] = new long[101][11][2][2];
        
        for(long a[][][] : dp){
            for(long b[][] : a){
                for(long c[] : b){
                    Arrays.fill(c,-1);
                }
            }
        }
        
        long res = f(0,-1,1,1,high,dp);
        
        int toAdd = 1;
        for(int i = 1 ; i < low.length() ; i++){
            int diff = low.charAt(i) - low.charAt(i-1);
            if(Math.abs(diff) != 1){
                toAdd = 0;
                break;
            }
        }
        
        // clearing the DP values for high
        for(long a[][][] : dp){
            for(long b[][] : a){
                for(long c[] : b){
                    Arrays.fill(c,-1);
                }
            }
        }
        
        res -= f(0,-1,1,1,low,dp);
        
        // high - low gives ans for [low+1,high]..but we want [low,high]..
        // so we check separately for low and if it is a stepping number,
        // we add +1 to ans...
        
        res = (res + MOD) % MOD;
        
        res = (res + MOD + toAdd) % MOD;
        
        return (int)res;
    }
    public static long f(int index, int prev, int tight, 
                        int leadingZeros, String num, long dp[][][][]){
        
        if(index == num.length()){
            return 1;
        }
        
        if(dp[index][prev+1][tight][leadingZeros] != -1){
            return dp[index][prev+1][tight][leadingZeros];
        }
        
        long hi = num.charAt(index) - '0';
        if(tight == 0){
            hi = 9;
        }
        
        long cnt = 0;
        
        for(int i = 0 ; i <= hi ; i++){
            
            int newTight = (tight == 1 && i == hi) ? 1 : 0;
            int newLZ = (leadingZeros == 1 && i == 0) ? 1 : 0;
            
            if(leadingZeros == 1 || Math.abs(i-prev) == 1){
                cnt += f(index+1,i,newTight,newLZ,num,dp) % MOD;
            }
        }
        
        return dp[index][prev+1][tight][leadingZeros] = cnt;
    }
}
class Solution {
    public long findKthSmallest(int[] coins, int k) {
        
        int n = coins.length;
        
        long lo = 1;
        long hi = (long)1e18;
        
        long ans = -1;
        
        while(lo <= hi){
            
            long mid = lo+(hi-lo)/2;
            
            if(k <= smallerThanX(coins,mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public long smallerThanX(int coins[], long x){
        
        int n = coins.length;
        
        long ans = 0;
        
        for(int mask = 1; mask < (1<<n) ; mask++){
            
            int cnt = 0;
            long lcm = 0;
            
            for(int i = 0 ; i < n ; i++){
                
                if((mask & (1 << (n-1-i))) == 0){
                    continue;
                }
                
                cnt++;
                
                if(lcm == 0){
                    lcm = coins[i];
                }else{
                    lcm = (coins[i]*lcm)/gcd(coins[i],lcm);
                }
            }
            
            if(cnt%2 != 0){
                ans = ans + (x/lcm);
            }else{
                ans = ans - (x/lcm);
            }   
        }
        
        return ans;
    }
    public long gcd(long A , long B) 
    {
        if(B==0)
            return A;
            
        return gcd(B,A%B);
    } 
}
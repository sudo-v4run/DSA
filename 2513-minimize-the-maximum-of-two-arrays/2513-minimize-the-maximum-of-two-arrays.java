class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int ans = -1;
        
        long lo = 1;
        long hi = (long)2e9;
        
        while(lo <= hi){
            long mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,divisor1,divisor2,uniqueCnt1,uniqueCnt2)){
                ans = (int)mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public boolean isPossible(long x, int d1, int d2, int u1, int u2){
        
        long divble_by_both = x/lcm(d1,d2);
        long divble_by_d1 = x/d1-divble_by_both;    
            // valid for arr2 expect divble_by_both set
        long divble_by_d2 = x/d2-divble_by_both;
            // valid for arr1 expect divble_by_both set
        
        long valid_for_both_arr1_arr2 = x-divble_by_d1-divble_by_d2-divble_by_both;
          // +divble_by_both is coz divble_by_both will be subtracted twice .i.e.
          // one set of divble_by_both from divble_by_d1 and another from divble_by_d2
        
        if(u1 > divble_by_d2){
            valid_for_both_arr1_arr2 -= (u1-divble_by_d2);
        }
        if(u2 > divble_by_d1){
            valid_for_both_arr1_arr2 -= (u2-divble_by_d1);
        }
        
        return valid_for_both_arr1_arr2 >= 0;
    }
    public long lcm(long a, long b){
        
        return (a*b)/gcd(a,b);
    }
    public long gcd(long A , long B) 
    { 
        if(B==0)
            return A;
            
        return gcd(B,A%B);
    }
}
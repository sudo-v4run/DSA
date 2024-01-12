class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        long ans = -1;
        
        long lo = 1;
        long hi = (long)2e9;
        
        while(lo <= hi){
            long mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,divisor1,divisor2,uniqueCnt1,uniqueCnt2)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return (int)ans;
    }
    public boolean isPossible(long x, int d1, int d2, int u1, int u2){
        
        long divble_by_both = x/lcm(d1,d2);
        
        long divble_by_only_d1 = x/d1-divble_by_both;    // valid for arr2
        long divble_by_only_d2 = x/d2-divble_by_both;    // valid for arr1
        
        long valid_for_both_arr1_arr2 
              = x-divble_by_only_d1-divble_by_only_d2-divble_by_both;
        
        if(u1 > divble_by_only_d2){
            valid_for_both_arr1_arr2 -= u1-divble_by_only_d2;
        }
        if(u2 > divble_by_only_d1){
            valid_for_both_arr1_arr2 -= u2-divble_by_only_d1;
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
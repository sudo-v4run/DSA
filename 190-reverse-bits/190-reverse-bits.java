public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res = 0;
        
        for(int i = 0 ; i <= 31 ; i++){
            res = res << 1;
            if((n&1)==1){
                res++;          // or res = res | 1
            }
            n = n >> 1;
        }
        
        return res;
        
        
        
//         int res = 0;
        
//         for(int i = 0 ; i <= 31 ; i++){
//             int bit = (n>>>i)&1;
//             res = res|(bit<<(31-i));
//         }
        
//         return res;
        
        
    }
}
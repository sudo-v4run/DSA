class Solution {
    public int mySqrt(int x) {
        
//         int s = 0;
//         int e = x/2;
        
//         int ans = -1;
        
//         while(s<=e){
//             int m = s+(e-s)/2;
            
//             if(m*m <= x){
//                 ans = m;
//                 s = m+1;
//             }else{
//                 e = m-1;
//             }
//         }
        
//         return ans;
        
        
        
        
        
        if (x == 0) return 0;
        int i = 1;
        while(i*i <= x){
            if (i <= x / i && (i + 1) > x / (i + 1))
                return i;
            i++;
        }
        return -1;
    }
}
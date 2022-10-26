class Solution {
    public int mySqrt(int x) {
        
        if(x==0)
            return 0;
        
        int s = 1;
        int e = x;
        
        int ans = -1;
        
        while(s<=e){
            int m = s+(e-s)/2;
            
            if(m <= x/m){
                ans = m;
                s = m+1;
            }else{
                e = m-1;
            }
        }
        
        return ans;
        
        
        
        
        
//         if (x == 0) return 0;
//         int i = 1;
//         while(i <= x/i) 
//             i++;
        
//         return i-1;
    }
}
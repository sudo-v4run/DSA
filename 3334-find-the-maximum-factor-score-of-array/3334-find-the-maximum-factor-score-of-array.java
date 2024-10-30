class Solution {
    public long maxScore(int[] arr) {
        
        int n = arr.length;
        
        if(n == 1){
            return arr[0]*arr[0];
        }
        
        long ans = 1;
        
        for(int i = -1 ; i < n ; i++){
            
            long gcd = (i == 0) ? arr[1] : arr[0];
            long lcm = gcd;
            
            for(int j = 0 ; j < n ; j++){
                
                if(j == i){
                    continue;
                }
                
                gcd = findGcd(gcd,arr[j]);
                lcm = lcm*arr[j] / findGcd(lcm,arr[j]);
            }
            
            ans = Math.max(ans,lcm*1l*gcd);
        }
        
        return ans;
    }
    public long findGcd(long a, long b){
        
        if(b == 0l){
            return a;
        }
        
        return findGcd(b,a%b);
    }
}
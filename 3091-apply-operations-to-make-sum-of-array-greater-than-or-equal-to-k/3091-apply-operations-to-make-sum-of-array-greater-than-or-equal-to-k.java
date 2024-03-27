class Solution {
    public int minOperations(int k) {
        
        int ans = Integer.MAX_VALUE;
        
        for(int a = 0 ; a < k ; a++){
            
            int curSum = 1 + a;
            
            int b = (int)Math.ceil((double)k/curSum);
        
            int ops = a+(b-1);
            
            ans = Math.min(ans,ops);
        }
        
        return ans;
    }
}
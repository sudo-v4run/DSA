class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0){
            return 1;
        }
        
        double half = myPow(x,Math.abs(n/2));
        
        double ans = half * half;
        
        if(n % 2 != 0){
            ans *= x;
        }
        
        if(n > 0){
            return ans;
        }
        
        return 1/ans;
    }
}
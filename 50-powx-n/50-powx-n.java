class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n==0)
            return 1;
        int N = 1;
        
        if(n == Integer.MIN_VALUE)
            N = Integer.MAX_VALUE;
        else
            N = Math.abs(n);
        
            
        ans = myPow(x,N/2);
        ans = ans*ans;
        if(N%2!=0)
            ans = ans*x;
        if(n<0){
            if(n==Integer.MIN_VALUE)
                return 1/(ans*x);
            else 
                return 1/ans;
        }
        
        return ans;
    }
}
class Solution {
//     public double myPow(double x, int n) {
        
//         if(n==0)
//             return 1;
        
//         double ans = 1;
            
//         ans = myPow(x,Math.abs(n/2));
//         ans = ans*ans;
        
//         if(n%2!=0)
//             ans = ans*x;
        
//         if(n<0)
//             return 1/ans;
        
//         return ans;
        
//     }
    
    
    public double myPow(double x,int N){
        double ans = 1;
        long n = (long)N;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        
        while(n>0){
            if(n%2==1){
                ans = ans*x;
            }
            
            x = x*x;
            n = n/2;
        }
        
        return ans;
    }
    
}
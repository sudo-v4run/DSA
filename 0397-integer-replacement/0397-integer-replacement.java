class Solution {
    public int integerReplacement(int n) {
        
        return f(n*1l);
    }
    public int f(long n){

        if(n == 1){
            return 0;
        }

        if(n%2 == 0){
            int ans = 1 + f(n/2);

            return (int)ans;
        }else{
            int ans = Math.min(f(n-1), f(n+1))+1;

            return (int)ans;
        }
    }
}
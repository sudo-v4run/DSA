class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        int ans = 0;

        for(int i = 0; i <= n ; i++){
            ans += f(i);
        }
        
        return ans;
    }
    public int f(int n){

        if(n > 10){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 9;
        }

        return f(n-1)*(10 - (n-1));
    }
}
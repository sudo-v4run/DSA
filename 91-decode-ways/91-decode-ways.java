class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        
        // Tabulation...
        
        int dp[] = new int[n+1];
        
        dp[n] = 1;
        
        for(int index = n-1; index>=0; index--){
            
            if(s.charAt(index)=='0'){
                dp[index] = 0;
                continue;
            }
            
            int take1digit = dp[index+1];
            int take2digits = 0;
            if(index+1 <= n-1 && ( (s.charAt(index)=='1') ||  
                (s.charAt(index)=='2' && 
                 (s.charAt(index+1)>='0' && s.charAt(index+1)<='6') ) ) ){

                take2digits = dp[index+2];
            }

            dp[index] = take1digit+take2digits;
        }
        
        return dp[0];
        
        // Memoization...
        
        // int dp[] = new int[n];
        
//         Arrays.fill(dp,-1);
        
//         return f(0,s,dp);
    }
    public static int f(int index,String s,int dp[]){
        
        if(index>=s.length())
            return 1;
        
        if(s.charAt(index)=='0')
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int take1digit = f(index+1,s,dp);
        int take2digits = 0;
        if(index+1 <= s.length()-1 && ( (s.charAt(index)=='1') ||  
            (s.charAt(index)=='2' && 
             (s.charAt(index+1)>='0' && s.charAt(index+1)<='6') ) ) ){
            
            take2digits = f(index+2,s,dp);
        }
        
        return dp[index] = take1digit+take2digits;
        
        
        
        // Recursion....
        
//         if(index>=s.length())
//             return 1;
        
//         if(s.charAt(index)=='0')
//             return 0;
        
//         int take1digit = f(index+1,s);
//         int take2digits = 0;
//         if(index+1 <= s.length()-1 && ( (s.charAt(index)=='1') ||  
//             (s.charAt(index)=='2' && 
//              (s.charAt(index+1)>='0' && s.charAt(index+1)<='6') ) ) ){
            
            
//             take2digits = f(index+2,s);
//         }
        
//         return take1digit+take2digits;
        
    }
}
class Solution {
    public boolean isMatch(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Tabulation....Buttom Up....
        
        int dp[][] = new int[n1+1][n2+1];
        
        dp[0][0] = 1;
        
        for(int index2 = 2 ; index2 <=n2 ; index2=index2+2){
            if(s2.charAt(index2-1)!='*'){
                break;
            }
            dp[0][index2-1] = 1;
            dp[0][index2] = 1;
        }
        
        for(int index1 = 1 ; index1 <= n1 ; index1++){
            
            for(int index2 = 1 ; index2 <= n2 ; index2++){
                
                if( s1.charAt(index1-1)==s2.charAt(index2-1)){
                    if(dp[index1-1][index2-1] == 1){
                        dp[index1][index2] = 1;
                    }
                }
                else if(s2.charAt(index2-1)=='.'){
                    if(dp[index1-1][index2-1] == 1){
                        dp[index1][index2] = 1;
                    }
                }else if(s2.charAt(index2-1)=='*'){
                    if( (s2.charAt(index2-2) == s1.charAt(index1-1) ||
                        s2.charAt(index2-2) == '.') &&
                        (dp[index1-1][index2] == 1 ||
                        dp[index1][index2-1] == 1 ) ){

                        dp[index1][index2] = 1;
                    }
                    if(dp[index1][index2-2] == 1){
                        dp[index1][index2] = 1;
                    }
                }
                
            }
        }
        
        return dp[n1][n2] == 1 ? true : false;
        
        
        
        
        
        
        // Memoization...Top Down...
        
//         int dp[][] = new int[n1][n2];
        
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(s,p,n1-1,n2-1,dp);
        
    }
    public static boolean f(String s1, String s2,
                            int index1, int index2,int dp[][]){
        
        if(index1<0){
            while(index2>=0 && s2.charAt(index2)=='*'){
                if(s2.charAt(index2)=='*'){
                    index2--;
                }
                index2--;
            }
            if(index2<0){
                return true;
            }else{
                return false;
            }
        }
        if(index2<0){
            return false;
        }
        
        if(dp[index1][index2] != -1){
            return dp[index1][index2]==1?true:false;
        }
        
        if( s1.charAt(index1)==s2.charAt(index2)){
            if(f(s1,s2,index1-1,index2-1,dp)){
                dp[index1][index2] = 1;
                return true;
            }
        }
        else if(s2.charAt(index2)=='.'){
            if(f(s1,s2,index1-1,index2-1,dp)){
                dp[index1][index2] = 1;
                return true;
            }
        }else if(s2.charAt(index2)=='*'){
            if( (s2.charAt(index2-1) == s1.charAt(index1) ||
                s2.charAt(index2-1) == '.') &&
                (f(s1,s2,index1-1,index2,dp) ||
                f(s1,s2,index1,index2-1,dp)) ){

                dp[index1][index2] = 1;
                return true;
            }
            if(f(s1,s2,index1,index2-2,dp)){
                dp[index1][index2] = 1;
                return true;
            }
        }
        
        dp[index1][index2] = 0;
        
        return false;
        
    }
}
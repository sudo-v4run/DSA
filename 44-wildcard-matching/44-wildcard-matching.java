class Solution {
    public boolean isMatch(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        
        // Tabulation Opimized....
        
        int cur[] = new int[n2+1];
        int prev[] = new int[n2+1];
        
        prev[0] = 1;
        
        for(int index2 = 1 ; index2 <= n2 ; index2++){
            if(s2.charAt(index2-1)!='*'){
                break;
            }
            prev[index2] = 1;
        }
        
        for(int index1 = 1 ; index1 <= n1 ; index1++){
            cur = new int[n2+1];
            for(int index2 = 1 ; index2 <= n2 ; index2++){
                
                if( s1.charAt(index1-1)==s2.charAt(index2-1) ||
                    s2.charAt(index2-1)=='?'){
                    if(prev[index2-1] == 1){
                        cur[index2] = 1;
                    }
                }else if(s2.charAt(index2-1)=='*'){
                    if( prev[index2] == 1 ||
                        cur[index2-1] == 1 ||
                        prev[index2-1] == 1 ){

                        cur[index2] = 1;
                    }
                }
                
            }
            prev = cur.clone();
        }
        
        return prev[n2] == 1 ? true : false;
        
        
        
        
        
        // Tabulation... Buttom Up...
        
//         int dp[][] = new int[n1+1][n2+1];
        
//         dp[0][0] = 1;
        
//         for(int index2 = 1 ; index2 <= n2 ; index2++){
//             if(s2.charAt(index2-1)!='*'){
//                 break;
//             }
//             dp[0][index2] = 1;
//         }
        
//         for(int index1 = 1 ; index1 <= n1 ; index1++){
            
//             for(int index2 = 1 ; index2 <= n2 ; index2++){
                
//                 if( s1.charAt(index1-1)==s2.charAt(index2-1) ||
//                     s2.charAt(index2-1)=='?'){
                    
//                     if(dp[index1-1][index2-1] == 1){
//                         dp[index1][index2] = 1;
//                     }
//                 }else if(s2.charAt(index2-1)=='*'){
//                     if( dp[index1-1][index2] == 1 ||
//                         dp[index1][index2-1] == 1 ||
//                         dp[index1-1][index2-1] == 1 ){

//                         dp[index1][index2] = 1;
//                     }
//                 }
                
//             }
//         }
        
//         return dp[n1][n2] == 1 ? true : false;
        
        
        
        
        
        
        
        
        // Memoization ... Top Down...
        
//         int dp[][] = new int[n1][n2];
        
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
        
//         return f(s1,s2,n1-1,n2-1,dp);
        
    }
    
    public static boolean f(String s1, String s2,
                            int index1, int index2,int dp[][]){
        
        if(index1<0){
            while(index2>=0 && s2.charAt(index2)=='*'){
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
        
        if( s1.charAt(index1)==s2.charAt(index2) || s2.charAt(index2)=='?'){
            if(f(s1,s2,index1-1,index2-1,dp)){
                dp[index1][index2] = 1;
                return true;
            }
        }else if(s2.charAt(index2)=='*'){
            if( f(s1,s2,index1-1,index2,dp) ||
                f(s1,s2,index1,index2-1,dp) ||
                f(s1,s2,index1-1,index2-1,dp) ){
                
                dp[index1][index2] = 1;
                return true;
            }
        }
        
        dp[index1][index2] = 0;
        
        return false;
        
        
        
        
        
        
        // Recursion....
//         if(index1<0){
//             while(index2>=0 && s2.charAt(index2)=='*'){
//                 index2--;
//             }
//             if(index2<0){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
//         if(index2<0){
//             return false;
//         }
        
//         if( s1.charAt(index1)==s2.charAt(index2)){
//             if(f(s1,s2,index1-1,index2-1))
//                 return true;
//         }
//         else if(s2.charAt(index2)=='?'){
//             if(f(s1,s2,index1-1,index2-1))
//                 return true;
//         }else if(s2.charAt(index2)=='*'){
//             if( f(s1,s2,index1-1,index2) ||
//                 f(s1,s2,index1,index2-1) ||
//                 f(s1,s2,index1-1,index2-1) ){
                
//                 return true;
//             }
//         }
        
//         return false;
    }
}
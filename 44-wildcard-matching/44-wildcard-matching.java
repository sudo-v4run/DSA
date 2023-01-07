class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        
        int dp[][] = new int[n1][n2];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(s,p,n1-1,n2-1,dp);
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
        
        if( s1.charAt(index1)==s2.charAt(index2)){
            if(f(s1,s2,index1-1,index2-1,dp)){
                dp[index1][index2] = 1;
                return true;
            }
        }
        else if(s2.charAt(index2)=='?'){
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
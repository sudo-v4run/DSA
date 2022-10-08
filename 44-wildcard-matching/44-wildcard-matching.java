class Solution {
    public boolean isMatch(String s2, String s1) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        
        // Memoization (Top - Down) ..
        int dp[][] = new int[n1][n2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        
        return wcm(n1-1,n2-1,s1,s2,dp)==1?true:false;
    }
    public static int wcm(int index1 , int index2 , String s1 , String s2,int dp[][]){
        if(index1<0 && index2<0){
            return 1;
        }
        if(index2 < 0 ){
            for(int i = 0 ; i <= index1 ; i++){
                if(s1.charAt(i)!='*')
                    return 0;
            }
            return 1;
        }
        
        if(index1 < 0 ){
            return 0;
        }
 
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2) || s1.charAt(index1)=='?'){
            return  dp[index1][index2] = wcm(index1-1,index2-1,s1,s2,dp);
        }
        if(s1.charAt(index1)=='*'){
            if(wcm(index1-1,index2 , s1, s2,dp)==1)
                return dp[index1][index2] = 1;
            if(wcm(index1,index2-1,s1,s2,dp)==1)
                return dp[index1][index2] = 1;
            return dp[index1][index2] = 0;
        }
        return dp[index1][index2] = 0;
        
        
        
        // Recursion ...
        
//         if(index1 < 0 ){
//             return 0;
//         }
//         if(index2 < 0 ){
//             for(int i = 0 ; i <= index1 ; i++){
//                 if(s1.charAt(i)!='*')
//                     return 0;
//             }
//             return 1;
//         }
//         if(index1<0 && index2<0){
//             return 1;
//         }
        
        
//         if(s1.charAt(index1)==s2.charAt(index2) || s1.charAt(index1)=='?'){
//             return wcm(index1-1,index2-1,s1,s2);
//         }
//         if(s1.charAt(index1)=='*'){
//             if(wcm(index1-1,index2 , s1, s2)==1)
//                 return 1;
//             if(wcm(index1,index2-1,s1,s2)==1)
//                 return 1;
//             return 0;
//         }
//         return wcm(index1-1,index2, s1,s2);
    }
}
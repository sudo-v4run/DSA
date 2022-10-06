class Solution {
    public int numDistinct(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Tabulation (Buttom-Up)... Space Optimized...1D Array...
        
//         int dp[] = new int[n2+1];
        
//         dp[0] = 1;
        
//         for(int index1 = 1 ; index1 <= n1 ; index1++){
//             for(int index2 = n2 ; index2 >=1 ; index2--){
//                 if(s1.charAt(index1-1)==s2.charAt(index2-1)){
//                     dp[index2] = dp[index2-1] + dp[index2];
//                 }
//             }
//         }
        
//         return dp[n2];
        
        
        
        
        // Tabulation (Buttom-Up)... Space Optimized...
        
        int cur[] = new int[n2+1];
        int prev[] = new int[n2+1];
        
        prev[0] = cur[0] = 1;
        
        for(int index1 = 1 ; index1 <= n1 ; index1++){
            for(int index2 = 1 ; index2 <= n2 ; index2++){
                if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                    cur[index2] = prev[index2-1] + prev[index2];
                }
                else
                    cur[index2] = prev[index2];
            }
            prev = cur.clone();
        }
        
        return prev[n2];
        
        
        // Tabulation (Buttom-Up)...
        
//         int dp[][] = new int[n1+1][n2+1];
//         for(int index1 = 0 ; index1 <= n1 ; index1++){
//             dp[index1][0] = 1;
//         }
        
//         for(int index1 = 1 ; index1 <= n1 ; index1++){
//             for(int index2 = 1 ; index2 <= n2 ; index2++){
//                 if(s1.charAt(index1-1)==s2.charAt(index2-1)){
//                     dp[index1][index2] = dp[index1-1][index2-1]
//                                                         + dp[index1-1][index2];
//                 }
//                 else
//                     dp[index1][index2] = dp[index1-1][index2];
//             }
//         }
        
//         return dp[n1][n2];
        
        
        
        // Memoization...(Top-Down)...
        
//         int dp[][] = new int[n1][n2];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return ds(n1-1,n2-1,s1,s2,dp);
    }
    
    public static int ds(int index1,int index2 ,String s1,String s2,int dp[][]){
        if(index1<index2)
            return 0;
        if(index2<0)
            return 1;
        if(index1<0)
            return 0;
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2] = ds(index1-1,index2-1,s1,s2,dp)
                                                + ds(index1-1,index2,s1,s2,dp);
        }
        return dp[index1][index2] = ds(index1-1,index2,s1,s2,dp);
        
        
        // Recursion ....
        
        
//         if(index2<0)
//             return 1;
//         if(index1<0)
//             return 0;
        
        
//         if(s1.charAt(index1)==s2.charAt(index2)){
//             return ds(index1-1,index2-1,s1,s2)+ds(index1-1,index2,s1,s2);
//         }
//         return ds(index1-1,index2,s1,s2);
    }
}
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Tabulation ... (Buttom-Up) ...Space Optimized...
        
//         int prev[] = new int[n2+1];
//         int cur[] = new int[n2+1];
        
//         for(int j = 0 ; j <= n2 ; j++){
//             prev[j] = 0;
//         }
        
//         for(int i = 1 ; i <= n1 ; i++){
//             for(int j = 1 ; j <= n2 ;j++){
//                  if(s1.charAt(i-1)==s2.charAt(j-1)){
//                     cur[j] = 1+prev[j-1];
//                 }
//                 else
//                     cur[j] = Math.max(prev[j],cur[j-1]);
//             }
//             prev = cur.clone();
//         }
        
//         return prev[n2];
        
        
        
        // Tabulation ... (Buttom-Up) ...
        
//         int dp[][] = new int[n1+1][n2+1];
        
//         for(int j = 0 ; j <= n2 ; j++){
//             dp[0][j] = 0;
//         }
        
//         for(int i = 0 ; i <= n1 ; i++){
//             dp[i][0] = 0;
//         }
        
//         for(int i = 1 ; i <= n1 ; i++){
//             for(int j = 1 ; j <= n2 ;j++){
//                  if(s1.charAt(i-1)==s2.charAt(j-1)){
//                     dp[i][j] = 1+dp[i-1][j-1];
//                 }
//                 else
//                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//             }
//         }
        
//         return dp[n1][n2];
        
        
        
        // Memoization ...(Top - Down) ...
        
        int dp[][] = new int[n1][n2];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return lcs(n1-1,n2-1,s1,s2,dp);
    }
    
    
    public static int lcs(int index1,int index2,String s1,String s2,int dp[][]){
        
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        
        int match = 0;
        
        if(s1.charAt(index1) == s2.charAt(index2)){
            match = 1+lcs(index1-1,index2-1,s1,s2,dp);
        }
        int notMatch = Math.max(lcs(index1-1,index2,s1,s2,dp),
                                lcs(index1,index2-1,s1,s2,dp));
        
        return dp[index1][index2] = Math.max(match,notMatch);
    }
}
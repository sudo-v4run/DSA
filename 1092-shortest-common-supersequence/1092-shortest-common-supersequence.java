class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = longestCommonSubsequence(s1,s2);
        
        String ans = "";
        
        int i = n1;
        int j = n2;
        
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                ans+=s2.charAt(j-1);
                j--;
            }else{
                ans+=s1.charAt(i-1);
                i--;
            }
        }
        
        while(i>0){
            ans+=s1.charAt(i-1);
            i--;
        }
        
        while(j>0){
            ans+=s2.charAt(j-1);
            j--;
        }
        
        String res = "";
        
        for(int index = ans.length()-1 ; index>=0 ; index--){
            res+=ans.charAt(index);
        }
        
        return res;
        
        
        
    }
    public int[][] longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Tabulation ... (Buttom-Up) ...
        
        int dp[][] = new int[n1+1][n2+1];
        
        for(int j = 0 ; j <= n2 ; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0 ; i <= n1 ; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1 ; i <= n1 ; i++){
            for(int j = 1 ; j <= n2 ;j++){
                 if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp;
        
        
        
        // Memoization ...(Top - Down) ...
//         int dp[][] = new int[n1][n2];
        
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return lcs(n1-1,n2-1,s1,s2,dp);
    }
    
    
    public static int lcs(int n1,int n2,String s1,String s2,int dp[][]){
        
        if(n1<0||n2<0){
            return 0;
        }
        
        if(dp[n1][n2] != -1)
            return dp[n1][n2];
        
        if(s1.charAt(n1)==s2.charAt(n2)){
            return 1+lcs(n1-1,n2-1,s1,s2,dp);
        }
        return dp[n1][n2] = Math.max(lcs(n1-1,n2,s1,s2,dp),lcs(n1,n2-1,s1,s2,dp));
        
        
        
        // Recursion ...
        
        // if(n1<0||n2<0){
        //     return 0;
        // }
        // if(s1.charAt(n1)==s2.charAt(n2)){
        //     return 1+lcs(n1-1,n2-1,s1,s2);
        // }
        // return Math.max(lcs(n1-1,n2,s1,s2),lcs(n1,n2-1,s1,s2));
    }
}
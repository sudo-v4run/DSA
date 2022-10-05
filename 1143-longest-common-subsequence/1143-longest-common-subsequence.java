class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Memoization ...(Top - Down) ...
        int dp[][] = new int[n1][n2];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return lcs(n1-1,n2-1,s1,s2,dp);
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
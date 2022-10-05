class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = "";
        int n1 = s1.length();
        
        for( int i = n1-1 ; i>=0 ; i-- ){
            s2+=s1.charAt(i);
        }
        int n2 = s2.length();
        
        
        
        // Tabulation ... (Buttom- Up)...
        
        int dp[][] = new int[n1+1][n2+1];
        
        for(int i2 = 0 ; i2 <= n2; i2++){
            dp[0][i2] = 0;
        }
        for(int i1 = 0 ; i1 <= n1; i1++){
            dp[i1][0] = 0;
        }
        
        for(int i1 = 1 ; i1<= n1 ; i1++){
            for(int i2=1 ; i2<=n2 ; i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){
                    dp[i1][i2] = 1+dp[i1-1][i2-1];
                }
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        }
        return dp[n1][n2];
        
        
        // Memoization ... (Top - Down)....
        
        // int dp[][] = new int[n1][n2];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        
        //return lcs(s1.length()-1,s2.length()-1,s1,s2,dp);
    }
    public int lcs(int index1, int index2 ,String s1,String s2,int dp[][]){
        
        if(index1<0||index2<0)
            return 0;
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2] = 1+lcs(index1-1,index2-1,s1,s2,dp);
        }
        return dp[index1][index2] = Math.max(lcs(index1-1,index2,s1,s2,dp),
                                                lcs(index1,index2-1,s1,s2,dp));
        
        
        
        
        // Recursion ....
        
        // if(index1<0||index2<0)
        //     return 0;
        // if(s1.charAt(index1)==s2.charAt(index2)){
        //     return 1+lcs(index1-1,index2-1,s1,s2);
        // }
        // return Math.max(lcs(index1-1,index2,s1,s2),lcs(index1,index2-1,s1,s2));
    }
}
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Tabulation (Buttom - UP) .. Space Optimized...
        
        int cur[] = new int[n2+1];
        int prev[] = new int[n2+1];
        
        cur[0] = prev[0] = 0;

        for(int index2 = 1 ; index2 <= n2 ; index2++ ){
            prev[index2] = index2;
        }
        
        
        for(int index1 = 1 ; index1 <=n1 ; index1++){
            cur[0] = index1;
            for(int index2 = 1 ; index2 <= n2 ; index2++){
                if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                    cur[index2] = 0 + prev[ index2 -1 ];
                }
                else
                   cur[index2] = Math.min( 1+ cur[index2-1], //insert
                                            Math.min(1+ prev[index2] , //delete
                                            1+ prev[index2-1])); //replace
            }
            prev = cur.clone();
        }
        
        return prev[n2];
        
        
        
        
        
        // Tabulation .. (Buttom - Up) ...
        
        // int dp[][] = new int[n1+1][n2+1];
        
        // dp[0][0] = 0;

        // for(int index1 = 1 ; index1 <= n1 ; index1++ ){
        //     dp[index1][0] = index1;
        // }
        // for(int index2 = 1 ; index2 <= n2 ; index2++ ){
        //     dp[0][index2] = index2;
        // }
        
        
        // for(int index1 = 1 ; index1 <=n1 ; index1++){
        //     for(int index2 = 1 ; index2 <= n2 ; index2++){
        //         if(s1.charAt(index1-1)==s2.charAt(index2-1)){
        //             dp[index1][index2] = 0 + dp[index1-1 ][ index2 -1 ];
        //         }
        //         else
        //             dp[index1][index2] = Math.min( 1+dp[index1][index2-1], //insert
        //                                     Math.min(1+dp[index1-1][index2] , //delete
        //                                     1+dp[index1-1][index2-1])); //replace
        //     }
        // }
        
        // return dp[n1][n2];
        
        
        // Memoization ..(Top - Down)...
        
        // int dp[][] = new int[n1][n2];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        
        // return nop(n1-1,n2-1,s1,s2,dp);
    }
    public static int nop(int index1, int index2 , String s1 , String s2,int dp[][]){
        if(index1<0 && index2<0)
            return 0;
        if(index1<0){
            return index2+1;
        }
        if(index2<0){
            return index1+1;
        }
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2] = 0 + nop(index1-1 , index2 -1 ,s1 , s2 ,dp);
        }
        return dp[index1][index2] = Math.min( 1+nop(index1,index2-1,s1,s2,dp), //insert
                            Math.min(1+nop(index1-1,index2,s1,s2,dp) , //delete
                            1+nop(index1-1,index2-1,s1,s2,dp))); //replace
    }
}
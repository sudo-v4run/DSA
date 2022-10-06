class Solution {
    public int numDistinct(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        
        // Memoization...(Top-Down)..
        int dp[][] = new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return ds(n1-1,n2-1,s1,s2,dp);
    }
    public static int ds(int index1,int index2 ,String s1,String s2,int dp[][]){
        
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
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // return lcsubstr(n-1,m-1,s1,s2);
        // Mp
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<= m ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return ans;
        
    }
    static int lcsubstr(int index1,int index2,String s1,String s2){
        if(index1<0||index2<0){
            return 0;
        }
        if(s1.charAt(index1)==s2.charAt(index2)){
            return 1+lcsubstr(index1-1,index2-1,s1,s2);
        }else{
            return 0;
        }
    }
}
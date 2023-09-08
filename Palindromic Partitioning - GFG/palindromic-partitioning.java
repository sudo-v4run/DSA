//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        
        int dp[][] = new int[n][n];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,n-1,str,dp);
    }
    public static int f(int i, int j, String str, int dp[][]){
        
        int n = str.length();
        
        if(i >= j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int mini = (int)1e7;
        
        for(int k = i ; k <= j ; k++){
            if(isPali(i,k,str)){
                if(k == n-1){
                    return 0;
                }
                int cuts = 1 + f(k+1,j,str,dp);
                mini = Math.min(mini,cuts);
            }
        }
        
        return dp[i][j] = mini;
    }
    public static boolean isPali(int i, int j, String str){
        
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
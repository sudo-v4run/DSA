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
        
        int dp[] = new int[n];
        
        Arrays.fill(dp,-1);
        
        return f(0,str,dp)-1;
    }
    public static int f(int i, String str, int dp[]){
        
        int n = str.length();
        
        if(i == n){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int mini = (int)1e7;
        
        for(int k = i ; k < n ; k++){
            if(isPali(i,k,str)){
                int cuts = 1 + f(k+1,str,dp);
                mini = Math.min(mini,cuts);
            }
        }
        
        return dp[i] = mini;
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
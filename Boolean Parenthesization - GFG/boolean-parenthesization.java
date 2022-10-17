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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int mod = 1003;
    
    static int countWays(int n, String s){
        
        
        //Memoization...
        
        int dp[][][] = new int[n][n][2];
        for(int arr1[][]:dp){
            for(int arr2[] : arr1){
                Arrays.fill(arr2,-1);
            }
        }
        return ebett(0,n-1,1,s,dp);
    }
    public static int ebett(int i , int j , int isTrue , String s,int dp[][][]){
        if(i>j)
            return 0;
        if(i==j){
            if(isTrue==1){
                if(s.charAt(i)=='T'){
                    return 1;
                }
                return 0;
            }else{
                if(s.charAt(i)=='F'){
                    return 1;
                }
                return 0;
            }
        }
        
        
        if(dp[i][j][isTrue] != -1)
            return dp[i][j][isTrue];
            
        int ways = 0;
        
        for(int index = i+1 ; index <= j-1 ; index+=2){
            
            int lT = ebett(i,index-1,1,s,dp);
            int lF = ebett(i,index-1,0,s,dp);
            int rT = ebett(index+1,j,1,s,dp);
            int rF = ebett(index+1,j,0,s,dp);
            
            if(s.charAt(index)=='&'){
                if(isTrue==1){
                    ways+=(lT*rT);
                }else{
                    ways+=(lT*rF+lF*rT+lF*rF);
                }
            }else if(s.charAt(index)=='|'){
                if(isTrue==1){
                    ways+=(lT*rF+lF*rT+lT*rT);
                }else{
                    ways+=(lF*rF);
                }
            }else{
                if(isTrue==1){
                    ways+=(lT*rF+lF*rT);
                }else{
                    ways+=(lT*rT+lF*rF);
                }
            }
        }
        
        return dp[i][j][isTrue] = ways%mod;
    }
}
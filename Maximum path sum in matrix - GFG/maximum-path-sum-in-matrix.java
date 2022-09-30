//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends

class Solution{
    static int maximumPath(int n, int arr[][])
    {
        
        // Memoization (Top - Down) ...
        int dp[][] = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int maxi = Integer.MIN_VALUE;
        for(int j = 0 ; j < n ; j++){
            maxi = Math.max(maxi,mpsm(n-1,j,arr,dp));
        }
        
        return maxi;
    }
    public static int mpsm(int i , int j , int arr[][], int dp[][]){
        
        if(j<0 || j>arr.length-1)
            return -100000000;
        if(i==0)
            return arr[0][j];
            
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int up = arr[i][j]+mpsm(i-1,j,arr,dp);
        int ld = arr[i][j]+mpsm(i-1,j-1,arr,dp);
        int rd = arr[i][j]+mpsm(i-1,j+1,arr,dp);
        
        return dp[i][j] = Math.max(up,Math.max(ld,rd));
        
        
        
        
        // Only Recursion ...
        // if(j<0 || j>arr.length-1)
        //     return -100000000;
        // if(i==0)
        //     return arr[0][j];
        
        // int up = arr[i][j]+mpsm(i-1,j,arr);
        // int ld = arr[i][j]+mpsm(i-1,j-1,arr);
        // int rd = arr[i][j]+mpsm(i-1,j+1,arr);
        
        // return Math.max(up,Math.max(ld,rd));
    }
}
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
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int dp[][] = new int[n][n];
        
        for(int i = n-1 ; i>= 1 ; i--){
            for(int j = i+1 ; j< n ; j++){
                int mini = Integer.MAX_VALUE;
                for(int k = i ; k < j ; k++){
                    int steps = (arr[i-1] * arr[k] * arr[j]) + 
                                    dp[i][k]+dp[k+1][j];
                                    
                    mini = Math.min(mini,steps);
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][n-1];
        
        // Memoization...
        // int dp[][] = new int[n][n];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
            
        // return noOp(1,n-1,arr,dp);
    }
    public static int noOp(int i , int j , int arr[], int dp[][]){
        if(i==j)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int mini = Integer.MAX_VALUE;
        
        for(int k = i ; k < j ; k++){
            int steps = (arr[i-1] * arr[k] * arr[j]) + 
                            noOp(i,k,arr,dp)+noOp(k+1,j,arr,dp);
                            
            mini = Math.min(mini,steps);
        }
        return dp[i][j] = mini;
        
        
        // Recursion....
        
        // if(i==j)
        //     return 0;
            
        // int mini = Integer.MAX_VALUE;
        
        // for(int k = i ; k < j ; k++){
        //     int steps = (arr[i-1] * arr[k] * arr[j]) + 
        //                     noOp(i,k,arr)+noOp(k+1,j,arr);
                            
        //     mini = Math.min(mini,steps);
        // }
        // return mini;
    }
}
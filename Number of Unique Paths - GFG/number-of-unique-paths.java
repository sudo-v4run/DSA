//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends

class Solution
{
    
    public static int NumberOfPath(int m, int n) 
    {
        //Memoization (Top - Down) ...
        
        // int dp[][] = new int[m][n];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return nup(m-1,n-1,dp);
        
        
        
        
        
        // Tabulation (Buttom-Up) ..
        
        //return nupT(m,n);
        
        
        
        
        // Tabulation (Buttom-Up) .. Space Optimized O(n)
        
        //return nupTSO(m,n);
        
        
        // Most Optimized Solution using Combinations ...
        
        int N = m+n-2;
        int R = m-1;
        double res = 1.0;
        
        for(int i = 1 ; i <=R ;i++){
            res = res*(N-i+1)/i;
        }
        
        return (int)res;
    }
    
    
    
    
    
    public static int nupT(int m , int n){
        int dp[][] = new int[m][n];
        
        dp[0][0] = 1;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0&&j==0)
                    continue;
                int up = 0;
                int left = 0;
                if(i>=1)
                    up = dp[i-1][j];
                if(j>=1)
                    left = dp[i][j-1];
                    
                dp[i][j] = up+left;
                
            }
        }
        
        return dp[m-1][n-1];
    }
    
    
    
    
    public static int nupTSO(int m , int n){
        int cur[] = new int[n];
        int prev[] = new int[n];
        
        cur[0] = 1;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0&&j==0)
                    continue;
                int up = 0;
                int left = 0;
                if(i>=1)
                    up = prev[j];
                if(j>=1)
                    left = cur[j-1];
                    
                cur[j] = up+left;
                
            }
            prev = cur.clone();
        }
        
        return prev[n-1];
    }
    
    
    
    
    
    
    
    public static int nup(int i , int j,int dp[][]){
        // DP
        if(i==0&&j==0)
            return 1;
        if(i<0||j<0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int up = nup(i-1,j,dp);
        int left = nup(i,j-1,dp);
        
        return dp[i][j] = up+left;
 
        
        
        
        
        // Recursion...
        
        // if(i==0&&j==0)
        //     return 1;
        // if(i<0||j<0)
        //     return 0;
        
        // int up = nup(i-1,j);
        // int left = nup(i,j-1);
        
        // return up+left;
        
        
    }
}
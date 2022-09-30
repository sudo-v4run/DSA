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
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return nup(m-1,n-1,dp);
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
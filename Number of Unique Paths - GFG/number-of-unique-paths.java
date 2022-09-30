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
        return nup(m-1,n-1);
    }
    public static int nup(int i , int j){
        if(i==0&&j==0)
            return 1;
        if(i<0||j<0)
            return 0;
        
        int up = nup(i-1,j);
        int left = nup(i,j-1);
        
        return up+left;
    }
}
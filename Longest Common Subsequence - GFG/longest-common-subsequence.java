//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][] = new int[x][y];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return lcsDP(x-1,y-1,s1,s2,dp);
    }
    static int lcsDP(int index1 , int index2 , String s1, String s2, int[][] dp){
        if(index1<0||index2<0)
            return 0;
            
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2] = 1+lcsDP(index1-1,index2-1,s1,s2,dp);
        }
        
        return dp[index1][index2] = 0 + Math.max( lcsDP(index1-1,index2,s1,s2,dp) , lcsDP(index1,index2-1,s1,s2,dp) );
    }
}
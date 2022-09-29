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
        //Memoization (Top-Down) ..
        
        // int dp[][] = new int[x][y];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return lcsDP(x-1,y-1,s1,s2,dp);
        
        
        
        // Tabulation (Buttom - Up) ... 
        
        //return lcsDPT(x,y,s1,s2);
        
        
        
        // Tabulation (Buttom - Up) ... Space Optimized..O(m)
        
        return lcsDPTSO(x,y,s1,s2);
        
    }
    
    static int lcsDPT(int m , int n , String s1, String s2){
        int dp[][] = new int[m+1][n+1];
        
        for(int j = 0 ;  j <= n ; j++){
            dp[0][j] = 0;
        }
        for(int i = 0 ;  i <= m ; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = 0 + Math.max( dp[i-1][j] , dp[i][j-1]);
            }
        }
        
        
        return dp[m][n];
    }
    
    
    static int lcsDPTSO(int m , int n , String s1, String s2){
        int cur[] = new int[n+1];
        int prev[] = new int[n+1];
        
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    cur[j] = 1+prev[j-1];
                else cur[j] = 0 + Math.max( cur[j-1] , prev[j]);
            }
            prev=(int[])(cur.clone());
        }
        
        
        return prev[n];
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
        
        
        //Using Recursion without DP....TLE ..
        
        // if(index1<0||index2<0)
        //     return 0;
        
        // if(s1.charAt(index1)==s2.charAt(index2)){
        //     return 1+lcsDP(index1-1,index2-1,s1,s2);
        // }
        
        // return 0 + Math.max( lcsDP(index1-1,index2,s1,s2) , lcsDP(index1,index2-1,s1,s2) );
    }
}
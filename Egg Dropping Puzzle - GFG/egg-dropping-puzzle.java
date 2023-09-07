//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends

class Solution 
{
    static int eggDrop(int n, int k) 
	{
	    
	    int dp[][] = new int[n+1][k+1];
	    
	    for(int row[] : dp){
	        Arrays.fill(row,-1);
	    }
	    
	    return f(n,k,dp);
	}
	public static int f(int eggs, int floors, int dp[][]){
	    
	    if(eggs == 1){
	        return floors;
	    }
	    
	    if(floors == 0 || floors == 1){
	        return floors;
	    }
	    
	    if(dp[eggs][floors] != -1){
	        return dp[eggs][floors];
	    }
	    
	    int mini = (int)1e7;
	    
	    for(int i = 1 ; i <= floors; i++){
	        
	        int attempts = 1 + Math.max(f(eggs-1,i-1,dp),f(eggs,floors-i,dp));
	            // refer to pepcoding explanation for better understanding
	        
            mini = Math.min(mini,attempts);
	    }
	    
	    return dp[eggs][floors] = mini;
	}
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends

class Solution
{
    int countWays(int n)
    {
        // Using only recursion without DP...
        
        // if(n==0)
        //     return 1;
        // if(n==1)
        //     return 1;
            
        // int singleStep = countWays(n-1);
        // int twoSteps = countWays(n-2);
        
        // return singleStep+twoSteps;
        
        
        // Using DP..
        
        
        //Memorization (Top - Down)...
        
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        
        // return countWaysDP(n,dp);
        
        
        //Tabulation (Buttom-Up)
        
        
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        
        // dp[0] = 1;
        // dp[1] = 1;
        
        // for(int i = 2 ; i <= n ; i++){
        //     dp[i] = (dp[i-1] % 1000000007 + dp[i-2] % 1000000007) % 1000000007 ;
        // }
        
        
        // return dp[n];
        
        
        // Tabulation (Buttom-Up) - Space Optimization - SC - O(1);
        
        int prev1 = 1;
        int prev2 = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int curi = (prev1 % 1000000007+prev2 % 1000000007) % 1000000007;
            
            prev2 = prev1;
            prev1 = curi;
        }
        
        return prev1;
            
    }
    int countWaysDP(int index, int dp[]){
        // Memorization (Top- Down)...
        
        if(index == 0)
            return 1;
            
        if(index == 1 )
            return 1;
            
        if(dp[index] != -1){
            return dp[index];
        }
        
        int singleStep = countWaysDP(index-1,dp);
        int twoSteps = countWaysDP(index-2,dp);
        
        return dp[index] = (singleStep+twoSteps)% 1000000007;
    }
}
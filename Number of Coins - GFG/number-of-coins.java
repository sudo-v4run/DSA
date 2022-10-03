//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int target) 
	{
	    
	    // Tabulation ... 
	    
	    
	    
	    
	    
	    
	   // Memoization ....(Top-Down) ...
	    int dp[][] = new int[n][target+1];
	    for(int[] row: dp){
	        Arrays.fill(row,-1);
	    }
	    
	    int ans = mnc(n-1,coins,target,dp);
	    if(ans>=(int)1e9){
	        return -1;
	    }
	    return ans;
	}
	public static int mnc(int index,int coins[],int target,int dp[][]){
	    
	    if(target==0){
	        return 0;
	    }
	    if(target<0)
	        return -1;
	    if(index==0){
	        if(target%coins[0]==0){
	            return target/coins[0];
	        }
	        return (int)1e9;
	    }
	    
	    if(dp[index][target] != -1)
	        return dp[index][target];
	    
	    int take = (int)1e9;
	    if(coins[index]<=target)
	        take = 1 + mnc(index,coins,target-coins[index],dp);
	    int notTake = 0 + mnc(index-1,coins,target,dp);
	    
	    return dp[index][target] = Math.min(take,notTake);
	    
	    
	    
	    
	    // Recursion ...
	    
	   // if(target==0){
	   //     return 0;
	   // }
	   // if(target<0)
	   //     return -1;
	   // if(index==0){
	   //     if(target%coins[0]==0){
	   //         return target/coins[0];
	   //     }
	   //     return (int)1e9;
	   // }
	   // int take = (int)1e9;
	   // if(coins[index]<=target)
	   //     take = 1 + mnc(index,coins,target-coins[index]);
	   // int notTake = 0 + mnc(index-1,coins,target);
	    
	   // return Math.min(take,notTake);
	}
}
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
	    
	    
	    // Tabulation ... Space Optimized ...
	    
	    int cur[] = new int[target+1];
	    int prev[] = new int[target+1];
	    
	    if(target==0)
	        return 0;
	    
	    for(int t = 0 ; t <= target ; t++){
	        if(t%coins[0]==0){
	            prev[t] = t/coins[0];
	        }else{
	            prev[t] = (int)1e9;
	        }
	    }
	    
	    for(int index = 1 ; index < n ; index++){
	        for(int t = 1 ; t <= target ; t++){
	            int take = (int)1e9;
        	    if(coins[index]<=t)
        	        take = 1 + cur[t-coins[index]];
        	    int notTake = 0 + prev[t];
        	    
        	    cur[t] = Math.min(take,notTake);
	        }
	        prev = cur.clone();
	    }
	    int ans = prev[target];
	    
	    if(ans>=(int)1e9){
	        return -1;
	    }
	    return ans;
	    
	    
	    
	    
	    
	    
	    // Tabulation ... 
	    
	    
	    
	   // int dp[][] = new int[n][target+1];
	    
	   // if(target==0)
	   //     return 0;
	    
	   // for(int t = 0 ; t <= target ; t++){
	   //     if(t%coins[0]==0){
	   //         dp[0][t] = t/coins[0];
	   //     }else{
	   //         dp[0][t] = (int)1e9;
	   //     }
	   // }
	    
	   // for(int index = 1 ; index < n ; index++){
	   //     for(int t = 1 ; t <= target ; t++){
	   //         int take = (int)1e9;
    //     	    if(coins[index]<=t)
    //     	        take = 1 + dp[index][t-coins[index]];
    //     	    int notTake = 0 + dp[index-1][t];
        	    
    //     	    dp[index][t] = Math.min(take,notTake);
	   //     }
	   // }
	   // int ans = dp[n-1][target];
	    
	   // if(ans>=(int)1e9){
	   //     return -1;
	   // }
	   // return ans;
	    
	    
	    
	   // Memoization ....(Top-Down) ...
	   
	   // int dp[][] = new int[n][target+1];
	   // for(int[] row: dp){
	   //     Arrays.fill(row,-1);
	   // }
	    
	   // int ans = mnc(n-1,coins,target,dp);
	   // if(ans>=(int)1e9){
	   //     return -1;
	   // }
	   // return ans;
	}
	
	
	public static int mnc(int index,int coins[],int target,int dp[][]){
	    
	    if(target==0){
	        return 0;
	    }
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
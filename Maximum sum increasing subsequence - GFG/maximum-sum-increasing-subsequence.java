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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{
	    int dp[][] = new int[n][n+1];
	    
	    for(int row[] : dp){
	        Arrays.fill(row,-1);
	    }
	    
	    return f(0,-1,arr,dp);
	}
	public static int f(int index, int prevInd, int arr[], int dp[][]){
	    
	    int n = arr.length;
	    
	    if(index == n){
	        return 0;
	    }
	    
	    if(dp[index][prevInd+1] != -1){
	        return dp[index][prevInd+1];
	    }
	    
	    int take = 0;
	    
	    if(prevInd == -1 || arr[index] > arr[prevInd]){
	        take = arr[index] + f(index+1,index,arr,dp);
	    }
	    int notTake = f(index+1,prevInd,arr,dp);
	    
	    return dp[index][prevInd+1] = Math.max(take,notTake);
	}
}
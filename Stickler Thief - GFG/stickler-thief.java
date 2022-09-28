//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    public int FindMaxSum(int arr[], int n)
    {
        // Recursion without DP...
        //return findMaxSumR(n-1,arr);
        
        
        
        // Recursion with DP...
        // Memorization(Top-Down) ...
        
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        
        return findMaxSumDP(n-1,arr,dp);
        
        // Tabulation (Buttom-Up) ...
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        
        // return findMaxSumT(n,arr,dp);
        
        // Tabulation (Buttom-Up) ..Space Optimized SC - O(1) ..
        
        // int prev = arr[0];
        // int prev2 = 0;
        
        // for(int i = 1 ; i < n ; i++){
        //     int takeThis = arr[i];
        //     if(i>1){
        //         takeThis+= prev2;
        //     }
        //     int notTake = 0 + prev;
            
        //     int curi = Math.max(takeThis,notTake);
        //     prev2 = prev;
        //     prev = curi;
        // }
        
        // return prev;
        
        
    }
    
    public int findMaxSumT(int n ,int arr[],int dp[]){
        
        dp[0] = arr[0];
        
        for(int i = 1 ; i < n ; i++){
            int takeThis = arr[i];
            if(i>1){
                takeThis+= dp[i-2];
            }
            int notTake = 0+dp[i-1];
            
            dp[i] = Math.max(takeThis,notTake);
        }
        
        return dp[n-1];
    }
    
    
    public int findMaxSumR(int index ,int arr[]){
        
        
        if(index==0)
            return arr[index];
        
        if(index<0)
            return 0;
        
        int takeThis = arr[index]+findMaxSumR(index-2,arr);
        int notTake = 0+findMaxSumR(index-1,arr);
        
        
        return Math.max(takeThis,notTake);
    }


    public int findMaxSumDP(int index,int arr[],int dp[]){
        if(index==0)
            return arr[0];
        
        if(index<0)
            return 0;
            
        if(dp[index]!=-1)
            return dp[index];
        
        int takeThis = arr[index]+findMaxSumDP(index-2,arr,dp);
        int notTake = 0+findMaxSumDP(index-1,arr,dp);
        
        
        return dp[index] = Math.max(takeThis,notTake);
    }
}
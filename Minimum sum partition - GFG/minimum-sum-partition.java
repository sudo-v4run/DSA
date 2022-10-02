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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends

class Solution {
    public int minDifference(int[] arr,int n) {
        int totSum = 0;
        for(int i : arr)
            totSum+=i;
        
        
        // Tabulation ...
        
        // boolean dp[][] = new boolean[n][k+1];
        
        // for(int index= 0 ; index < n ; index++){
        //     dp[index][0] = true;
        // }
        
        // if(arr[0]<=k) dp[0][arr[0]] = true;
        
        // for(int index=1 ; index<n ; index++){
        //     for(int target=1 ; target<=k ; target++){
        //         boolean pick = false;
        //         if(arr[index] <= target)
        //             pick = dp[index-1][target-arr[index]];
        //         boolean notPick = dp[index-1][target];

        //         dp[index][target] = pick|notPick;
        //     }
        // }
        // return dp[n-1][k];
        
        
        
        
        // Tabulation Space Optimized ... O(k+1)
        int k = totSum;
        boolean cur[] = new boolean[k+1];
        boolean prev[] = new boolean[k+1];
        
        for(int index= 0 ; index < n ; index++){
            prev[0] = true;
        }
        
        if(arr[0]<=k) prev[arr[0]] = true;
        
        for(int index=1 ; index<n ; index++){
            for(int target=1 ; target<=k ; target++){
                boolean pick = false;
                if(arr[index] <= target)
                    pick = prev[target-arr[index]];
                boolean notPick = prev[target];

                cur[target] = pick|notPick;
            }
            prev = cur.clone();
        }
              
        
        int ans = Integer.MAX_VALUE;
        for(int s1 = 0 ; s1 <= totSum ; s1++){
            if(prev[s1]==true){
                int s2 = totSum -s1;
                ans = Math.min(ans,Math.abs(s1-s2));
            }
        }
        
        return ans;
    }
}
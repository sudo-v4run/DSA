//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
        
        
        
        // Tabulation (Buttom - Up) ....
        
        int dp[][] = new int[n][W+1];
        
        for(int w = wt[0] ; w<= W ; w++){
            dp[0][w] = (w/wt[0])*val[0];
        }
        
        for(int item = 1 ; item< n ; item++){
            for(int w = 0 ; w<= W ; w++){
                int pick = 0;
                if(wt[item]<=w){
                    pick += val[item] + dp[item][w-wt[item]];
                }
                int notPick = 0 + dp[item-1][w];
                
                dp[item][w] =  Math.max(pick,notPick);
            }
        }
        return dp[n-1][W];
        
        
        
        // Memoization .. (Top - Down) ...
        
        // int dp[][] = new int[n][W+1];
        // for(int[] row :dp){
        //     Arrays.fill(row,-1);
        // }
        // return uks(n-1,W,val,wt,dp);
        
        
        
    }
    
    static int uks(int item,int W,int val[],int wt[],int dp[][]){
        
        if(item==0){
            if(wt[item]<=W){
                return (W/wt[item])*val[item];
            }
            return 0;
        }
        
        if(dp[item][W] != -1)
            return dp[item][W];
        
        int pick = 0;
        if(wt[item]<=W){
            pick += val[item] + uks(item,W-wt[item],val,wt,dp);
        }
        int notPick = 0 + uks(item-1,W,val,wt,dp);
        
        return dp[item][W] =  Math.max(pick,notPick);
        
        
        
        
        // Recursion ...
        // if(item==0){
        //     if(wt[item]<=W){
        //         return (W/wt[item])*val[item];
        //     }
        //     return 0;
        // }
        // int pick = 0;
        // if(wt[item]<=W){
        //     pick += val[item] + uks(item,W-wt[item],val,wt);
        // }
        // int notPick = 0 + uks(item-1,W,val,wt);
        
        // return Math.max(pick,notPick);
    }
}
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{
    static int knapSack(int totW, int wt[], int val[], int n) 
    {
        
        
        
        // Tabulation - Space Optimized- Only 1D Array ....
        
        if(totW==0)
            return 0;
            
        int prev[] = new int[totW+1];
        
        
        
        for(int w=wt[0] ; w<=totW ; w++){
            prev[w] = val[0];
        }
        
        for(int item = 1 ; item < n ; item++){
            for(int w = totW ; w>=1 ; w--){
                int take = 0;
                if(wt[item]<=w){
                    take = val[item] + prev[w-wt[item]];
                }
                int notTake = 0 + prev[w];
                prev[w] = Math.max(take,notTake);
            }
        }
        
        
        return prev[totW];
        
        
        // Memoization (Top-Down)  ...
        
        // int dp[][] = new int[n][totW+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return ks01(n-1,totW,wt,val,dp);
        
        
        
        
        
        // Tabulation (Buttom - Up) ...
        
        // if(totW==0)
        //     return 0;
        
        // int dp[][] = new int[n][totW+1];
        
        
        
        // for(int w=wt[0] ; w<=totW ; w++){
        //     dp[0][w] = val[0];
        // }
        
        // // for(int w=0 ; w<=totW ; w++){
        // //     if(wt[0]<=w){
        // //         dp[0][w] = val[0];
        // //     }
        // // }
        
        // for(int item = 1 ; item < n ; item++){
        //     for(int w = 1; w<=totW ; w++){
        //         int take = 0;
        //         if(wt[item]<=w){
        //             take = val[item] + dp[item-1][w-wt[item]];
        //         }
        //         int notTake = 0 + dp[item-1][w];
        //         dp[item][w] = Math.max(take,notTake);
        //     }
        // }
        
        
        // return dp[n-1][totW];
        
        
        
        // Tabulation Space Optimized ....
        
        // if(totW==0)
        //     return 0;
        
        // int cur[] = new int[totW+1];
        // int prev[] = new int[totW+1];
        
        
        
        // for(int w=wt[0] ; w<=totW ; w++){
        //     prev[w] = val[0];
        // }
        
        // for(int item = 1 ; item < n ; item++){
        //     for(int w = 1 ; w<=totW ; w++){
        //         int take = 0;
        //         if(wt[item]<=w){
        //             take = val[item] + prev[w-wt[item]];
        //         }
        //         int notTake = 0 + prev[w];
        //         cur[w] = Math.max(take,notTake);
        //     }
        //     prev = cur.clone();
        // }
        
        
        // return prev[totW];
        

        
    }
    public static int ks01(int item,int totW,int wt[],int vl[],int dp[][]){
        
        if(totW==0)
            return 0;
        if(item==0){
            if(wt[item]<=totW)
                return vl[item];
            return 0;
        }
        if(dp[item][totW] != -1)
            return dp[item][totW];
        int take = 0;
        if(wt[item]<=totW){
            take = vl[item] + ks01(item-1,totW-wt[item],wt,vl,dp);
        }
        int notTake = 0 + ks01(item-1,totW,wt,vl,dp);
        return dp[item][totW] = Math.max(take,notTake);
        
        
        
        
        // Recursion ... 

        // if(totW==0)
        //     return 0;
        // if(item==0){
        //     if(wt[item]<=totW)
        //         return vl[item];
        //     return 0;
        // }
        // int take = 0;
        // if(wt[item]<=totW){
        //     take = vl[item] + ks01(item-1,totW-wt[item],wt,vl);
        // }
        // int notTake = 0 + ks01(item-1,totW,wt,vl);
        // return Math.max(take,notTake);
    }
}



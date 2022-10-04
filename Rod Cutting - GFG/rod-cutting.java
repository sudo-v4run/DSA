//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        
        // Memoization (Top- Down) ...
        
        int dp[][] = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return rcp(n-1,n,price,dp);
    }
    public static int rcp(int index, int rodLen,int price[],int dp[][]){
        
        
        if(index==0){
            return price[0]*rodLen;
        }
        
        if(dp[index][rodLen] != -1)
            return dp[index][rodLen];
        
        int cut = 0;
        if(index+1<=rodLen)
            cut += price[index] + rcp(index, rodLen-(index+1), price,dp);
        int notCut = 0 + rcp(index-1, rodLen, price,dp);
        
        return dp[index][rodLen] = Math.max(cut,notCut);
        
        
        
        // Recursion ... 
        // if(index==0){
        //     return price[0]*rodLen;
        // }
        // int cut = 0;
        // if(index+1<=rodLen)
        //     cut += price[index] + rcp(index, rodLen-(index+1), price);
        // int notCut = 0 + rcp(index-1, rodLen, price);
        
        // return Math.max(cut,notCut);
    }
}
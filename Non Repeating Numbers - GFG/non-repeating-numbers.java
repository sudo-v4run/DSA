//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends

class Solution
{
    public int[] singleNumber(int[] arr)
    {
        int xxory = 0;
        
        for(int val : arr){
            xxory = xxory ^ val;
        }
        
        // separating x and y...
        
        int rmsb = xxory & -xxory;  // right most set bit mask
        
        int x = 0, y = 0;
        
        for(int val : arr){
            if((val & rmsb) == 0){
                x = x ^ val;
            }else{
                y = y ^ val;
            }
        }
        
        if(x < y){
            return new int[]{x,y};
        }
        return new int[]{y,x};
    }
}
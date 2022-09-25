//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends

class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(dep);
        Arrays.sort(arr);
        int a = 1;
        int d = 0;
        int max = 1;
        int minP = 1;
        
        while(a<n && d<n){
            if(arr[a]<=dep[d]){
                a++;
                max++;
                
            }else{
                max--;
                d++;
            }
            minP = Math.max(max,minP);
        }
        
        return minP;
    }
    
}


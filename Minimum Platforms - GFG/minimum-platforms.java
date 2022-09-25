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
        
        while(a<n){
            if(arr[a]>dep[d]){
                d++;
                max--;
                
            }
            else{
                a++;
                max++;
            }
            minP=Math.max(max,minP);}
        
        // int min_p = 1;
        // int needed_p=1;
        // Arrays.sort(arr);
        // Arrays.sort(dep);
        // int i=1,j=0;
        // while(i<n & j<n){
        //     if(arr[i]>dep[j]){
        //         j++;
        //         min_p--;
                
        //     }
        //     else{
        //         i++;
        //         min_p++;
        //     }
        //     needed_p=Math.max(needed_p,min_p);
        // }
        // return needed_p;
        
        return minP;
    }
    
}


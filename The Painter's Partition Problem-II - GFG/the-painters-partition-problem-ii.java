//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends

 class Solution{
    static long minTime(int[] arr,int n,int k){
        
        long max = -1;
        long sum = 0;
        
        for(int i : arr){
            if(i > max){
                max = i;
            }
            sum += i;
        }
        
        long lo = max;
        long hi = sum;
        while(lo <= hi){
            long mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,k,arr)){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    public static boolean isPossible(long maxTime, int k, int arr[]){
        
        int n = arr.length;
        long time = arr[0];
        int painters = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(time+arr[i] <= maxTime){
                time += arr[i];
            }else{
                painters++;
                time = arr[i];
            }
        }
        
        return painters <= k;
    }
}



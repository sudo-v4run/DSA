//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends

class Solution
{
    static long cnt;
    
    static long inversionCount(long arr[], long N)
    {
        cnt = 0;
        merge(arr,0,arr.length-1);
        
        return cnt;
    }
    static void merge(long arr[], int l, int h){
        if(l < h){
            int mid = (l+h)/2;
            
            merge(arr,l,mid);
            merge(arr,mid+1,h);
            mergeSort(arr,l,mid,h);
        }
    }
    static void mergeSort(long arr[], int l, int m, int h){
        int left = l;
        int right = m+1;
        int n = (m-l+1) + (h-m+1+1);
        long temp[] = new long[n];
        int k = 0;
        
        while(left <= m && right <= h){
            if(arr[left] > arr[right]){
                cnt += m - left + 1;
                temp[k++] = arr[right++];
            }else{
                temp[k++] = arr[left++];
            }
        }
        
        while(left <= m){
            temp[k++] = arr[left++];
        }
        while(right <= h){
            temp[k++] = arr[right++];
        }
        
        k = 0;
        
        for(int i = l ; i <= h ; i++){
            arr[i] = temp[k++];
        }
    }
}
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
    Solution(){
        cnt = 0;
    }
    static long inversionCount(long arr[], long N)
    {
        mergeSort(arr,0,arr.length-1);
        
        return cnt;
    }
    public static void mergeSort(long arr[], int l, int h){
        
        if(l<h){
            int m = (l+h)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,h);
            merge(arr,l,m,h);
        }
    }
    public static void merge(long arr[],int l, int m , int h){
        int i = l;
        int j = m+1;
        
        long temp[] = new long[h-l+1];
        int k = 0;
        
        while(i<=m && j<=h){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                cnt += m-i+1;
            }
        }
        
        while(i<=m){
            temp[k++] = arr[i++];
        }
        
        while(j<=h){
            temp[k++] = arr[j++];
        }
        
        i = l;
        k = 0;
        
        for( ; i<=h ; i++){
            arr[i] = temp[k++];
        }
    }
}
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int n)
    {
        int curElement = -1;
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(cnt==0){
                curElement = a[i];
                cnt = 1;
            }else{
                if(a[i]==curElement){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        cnt=0;
        for(int i = 0 ; i < n ; i++){
            if(a[i]==curElement){
                cnt++;
            }
        }
        if(cnt>(n/2)){
            return curElement;
        }
        
        return -1;
    }
}
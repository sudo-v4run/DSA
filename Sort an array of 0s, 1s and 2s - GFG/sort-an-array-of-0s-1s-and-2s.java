// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp = a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }else if(a[mid]==1){
                mid++;
            }else{
                int temp = a[high];
                a[high]=a[mid];
                a[mid]=temp;
                high--;
            }
        }
        
        
        // int cnt0=0,cnt1=0;
        // for(int i = 0 ; i < n ; i++){
        //     if(a[i]==0)
        //         cnt0++;
        //     else if(a[i]==1)
        //         cnt1++;
        // }
        // for(int i = 0 ; i< n ; i++){
        //     while(cnt0!=0){
        //         a[i]=0;
        //         cnt0--;
        //         i++;
        //     }
        //     while(cnt1!=0){
        //         a[i]=1;
        //         cnt1--;
        //         i++;
        //     }
        //     a[i]=2;
        // }
        
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends
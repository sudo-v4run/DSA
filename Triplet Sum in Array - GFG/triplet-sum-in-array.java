// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int arr[], int n, int sum) {
        Arrays.sort(arr);
       for(int i = 0 ; i < n ; i++){
            boolean ans = find2Sum(arr, sum-arr[i],i);
            if(ans)
                return true;
       }
       return false;
    }
    public static boolean find2Sum(int arr[] , int sum , int i){
        //Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            if(arr[l]==arr[i]){
                l++;
            }else if(arr[r]==arr[i]){
                r--;
            }else{
                if(arr[l]+arr[r]==sum){
                    return true;
                }else if(arr[l]+arr[r]>sum){
                    r--;
                }else{
                    l++;
                }
            }
            
        }
        
        return false;
    }
}

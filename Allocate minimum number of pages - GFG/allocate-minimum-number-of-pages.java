//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends

class Solution 
{
    public static int findPages(int[] arr, int n, int m)
    {
        if(m > n){
            return -1;
        }
        
        int max = -1;
        int sum = 0;
        
        for(int i : arr){
            if(i > max){
                max = i;
            }
            sum += i;
        }
        
        int lo = max;
        int hi = sum;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            int students = studentsCnt(mid,arr,m);
            
            if(students > m){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        return lo;
    }
    public static int studentsCnt(int pages, int arr[], int m){
        
        int n = arr.length;
        int students = 1;
        int curPages = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(curPages + arr[i] <= pages){
                curPages += arr[i];
            }else{
                students++;
                curPages = arr[i];
            }
        }
        
        return students;
    }
};
// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}// } Driver Code Ends


class Solution
{
    int thirdLargest(int arr[], int n)
    {
	    if(n<3)
	        return -1;
	        
	   int first = 0 , second = 1 , third = -1;
	   
	   for(int i = 1 ; i < n ; i++){
	       if(arr[i]>arr[first]){
	           third = second;
               second  = first;
               first = i;
	       }
	       else if(arr[i]>arr[second]){
               third = second;
               second = i;
	       }
	       else if(third==-1||arr[i]>arr[third]){
               third = i;
           }
	   }
	   
	   if(third == -1) return -1;
	   else return arr[third];
	   
	   
	   
	   
	   //If the given elements are not distint ----
	   
	   //if(n<3)
	   //     return -1;
	        
	   //int first = 0 , second = 1 , third = -1;
	   
	   //for(int i = 1 ; i < n ; i++){
	   //    if(arr[i]>arr[first]){
	   //        third = second;
    //           second  = first;
    //           first = i;
	   //    }else if(arr[i]<arr[first]){
	   //        if(arr[i]>arr[second]){
	   //            third = second;
	   //            second = i;
	   //        }else if(arr[i]<arr[second]){
	   //            if(third==-1||arr[i]>arr[third]){
	   //                third = i;
	   //            }
	   //        }
	   //    }
	   //}
	   
	   //if(third == -1) return -1;
	   //else return arr[third];
    }
}

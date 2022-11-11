//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int []ans= obj.sortArr(arr, n);
            for(int i=0;i<n;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        
    }
}
// } Driver Code Ends

class Solution 
{ 
    int[] sortArr(int[] arr, int n) 
    {
        quickSort(arr,0,arr.length-1);
        
        return arr;
    }
    public static void quickSort(int arr[],int l ,int h){
        if(l<h){
            int pivot = partitionLogic(arr,l,h);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,h);
        }
    }
    public static int partitionLogic(int arr[],int l , int h){
        int pivot = arr[l];
        int i = l;
        int j = h;
        
        while(i<j){
            while(i<j && arr[i]<=pivot)i++;
            while(arr[j]>pivot)j--;
            
            if(i<j){
                swap(arr,i,j);
            }
        }
        
        swap(arr,j,l);
        
        return j;
    }
    public static void swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 
// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int arr[], int l, int h, int x)
    {
        while(l<=h){
            int m = l+(h-l)/2;
            if(x==arr[m]){
                return m;
            }
            if(arr[l]<=arr[m]){
                if(x>=arr[l] && x<arr[m]){
                    h = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if(x>arr[m] && x<arr[h]){
                    l = m+1;
                }else{
                    h=m-1;
                }
            }
        }
        
        return -1;
    }
}
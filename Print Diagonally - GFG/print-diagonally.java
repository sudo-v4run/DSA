// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int n, int A[][])
    {
        ArrayList<Integer> res = new ArrayList<>();
        for(int k = 0 ; k < n ; k++){
            int i = 0;
            int j = k;
            while(j>=0){
                res.add(A[i][j]);
                i++;
                j--;
            }
        }
        for(int k = 1 ; k < n ; k++){
            int i = k ;
            int j =n-1;
            while(i<=n-1){
                res.add(A[i][j]);
                i++;
                j--;
            }
        }
        
        return res;
    }
}

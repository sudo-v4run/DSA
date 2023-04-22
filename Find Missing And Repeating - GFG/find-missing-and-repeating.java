//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends

class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        int xxory = 0;
        
        for(int val : arr){
            xxory = xxory ^ val;
        }
        
        for(int i = 1 ; i <= n ; i++){
            xxory = xxory ^ i;
        }
        
        // separating x and y...
        
        int rmsb = xxory & -xxory;  // right most set bit mask
        
        int x = 0, y = 0;
        
        for(int val : arr){
            if((val & rmsb) == 0){
                x = x ^ val;
            }else{
                y = y ^ val;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            if((i & rmsb) == 0){
                x = x ^ i;
            }else{
                y = y ^ i;
            }
        }
        
        for(int val : arr){
            if(x == val){
                return new int[]{x,y};
            }
        }
        return new int[]{y,x};
    }
}
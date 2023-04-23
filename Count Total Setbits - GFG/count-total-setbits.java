//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int countBits(int n){
        
        if(n <= 0){
            return 0;
        }
        
        int x = 0; // x in  2^x <= n
        
        while((1<<x) <= n){
            x++;
        }
        x--;
        
        int sbtm = (1 << (x-1)) * x; // set bits till m-1 = 2^(x-1) * x
        
        int sbmn = n - (1 << x) + 1;
        int rest = n - (1 << x);
        
        sbmn += countBits(rest);  // set bits from m to n
        
        return sbtm + sbmn;
    }
}
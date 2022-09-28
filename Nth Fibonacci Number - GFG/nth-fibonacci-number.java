// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}// } Driver Code Ends

class Solution {
    static long nthFibonacci(long n){
        
        // Using only recursion without DP..
        
        // if(n==0)
        //     return 0;
        // if(n==1)
        //     return 1;
        
        // return nthFibonacci(n-1) % 1000000007 +nthFibonacci(n-2) % 1000000007;
        
        
        //Using Memorization (Top - Down)...
        
        // int dp[] = new int[(int)n+1];
        // Arrays.fill(dp,-1);
        // return nthFibonacciDP((int)n,dp);
        
        
        //Using Tabulation (Buttom - Up) .. 
        
        // int dp[] = new int[(int)n+1];
        // Arrays.fill(dp,-1);
        
        // dp[0] = 0 ;
        // dp[1] = 1 ;
        
        // int N = (int) n;
        
        // for(int i = 2 ; i <= N ; i++ ){
        //     dp[i] = (dp[i-1]%1000000007 + dp[i-2]%1000000007)%1000000007 ;
        // }
        
        // return dp[N];
        
        // Using Tabulation but with Space Optimization -- SC - O(1);
       
        
        int prev2 = 0 ;
        int prev1 = 1 ;
        
        int N = (int) n;
        
        for(int i = 2 ; i <= N ; i++ ){
            int curi = (prev1%1000000007 + prev2%1000000007)%1000000007 ;
            prev2 = prev1;
            prev1 = curi;
        }
        
        return prev1;
        
        
    }
    
    static int nthFibonacciDP(int index , int dp[]){
        if(index==0)
            return 0;
            
        if(index==1)
            return 1;
            
        if(dp[index] != -1)
            return dp[index];
        
        return dp[index] = (nthFibonacciDP(index-1,dp)%1000000007 
                                + nthFibonacciDP(index-2,dp)%1000000007)%1000000007;
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);    // 2 consecutive stalls in right order has the min dist...
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int i : stalls){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }
        
        int lo = 1;
        int hi = max-min;   // for the case of 2 cows... so it will do for more cows as well
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,k,stalls)){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        return hi;
    }
    public static boolean isPossible(int dist, int k, int stalls[]){
        
        int n = stalls.length;
        int cows = 1;
        int last = stalls[0];
        
        for(int i = 1 ; i < n ; i++){
            if(stalls[i]-last >= dist){
                cows++;
                last = stalls[i];
            }
        }
        
        return cows >= k;
    }
}
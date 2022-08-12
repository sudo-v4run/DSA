//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long N) 
    {
        int n = (int)N;
        int ps[] = new int[n];
        int ns[] = new int[n];
        ps = previousSmaller(arr);
        ns = nextSmaller(arr);
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(ns[i]==-1){
                ns[i] = n;
            }
            long width = ns[i]-ps[i]-1;
            ans = Math.max(ans,arr[i]*width);
        }
        
        return ans;
    }
    public static int[] previousSmaller(long arr[]){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }
    public static int[] nextSmaller(long arr[]){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n-1 ; i >=0; i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }
        
}




//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{
	    Queue<Integer> p = new LinkedList<>();
	    Queue<Integer> t = new LinkedList<>();
	    
	    for(int i = 0 ; i < arr.length ; i++){
	        if(arr[i] == 'P'){
	            p.add(i);
	        }else{
	            t.add(i);
	        }
	    }
	    
	    int ans = 0;
	    
	    while(!p.isEmpty() && !t.isEmpty()){
	        if(Math.abs(p.peek()-t.peek()) <= k){
	            ans++;
	            p.poll();
	            t.poll();
	        }else if(p.peek() > t.peek()){
	            t.poll();
	        }else{
	            p.poll();
	        }
	    }
	    
	    return ans;
	} 
} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends
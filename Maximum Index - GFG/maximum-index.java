// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int arr[], int n) { 
        
        int ans = 0;
        
        int LMin[] = new int[n];
        int RMax[] = new int[n];
        
        LMin[0] = arr[0];
        RMax[n-1] = arr[n-1];
        
        for(int i = 1 ; i < n ; i++){
            LMin[i] = Math.min(LMin[i-1],arr[i]);
        }
        
        for(int i = n-2 ; i>=0 ; i--){
            RMax[i] = Math.max(RMax[i+1],arr[i]);
        }
        int i = 0 , j = 0 ;
        
        while(i<n && j<n){
            if(RMax[j]>=LMin[i]){
                ans = Math.max(ans,j-i);
                j++;
            }else{
                i++;
            }
        }
        
        return ans;
    }
}



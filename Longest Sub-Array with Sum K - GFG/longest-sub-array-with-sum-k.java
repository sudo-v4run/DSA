//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends

class Solution{
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        
        // If all the elements in the array are +ve, best soln is by using 2 pointers/sliding window...
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int prefixSum = 0;
        int i = 0;
        int max = 0;
        
        while(i < n){
            prefixSum += arr[i];
            
            if(prefixSum == k){
                max = Math.max(max,i+1);
            }else if(hm.containsKey(prefixSum-k)){
                max = Math.max(max,i-hm.get(prefixSum-k));
            }
            if(!hm.containsKey(prefixSum)){
                hm.put(prefixSum,i);
            }
            i++;
        }
        
        return max;
    }
}



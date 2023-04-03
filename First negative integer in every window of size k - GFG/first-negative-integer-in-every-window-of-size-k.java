//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends

class Compute 
{
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        
        int i = 0, j = 0;
        long ans[] = new long[n-k+1];
        Queue<Long> q = new LinkedList<>();
        int ind = 0;
        
        while(j<n){
            
            if(arr[j] < 0){
                q.add(arr[j]);
            }
            
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                
                if(q.size()==0){
                    ans[ind++] = 0;
                }else{
                    ans[ind++] = q.peek();
                    if(arr[i] == q.peek()){
                        q.poll();
                    }
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}
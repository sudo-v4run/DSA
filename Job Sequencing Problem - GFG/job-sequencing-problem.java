//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->{
            return b.profit - a.profit;
        });
        
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,arr[i].deadline);
        }
        
        int dls[] = new int[max];
        Arrays.fill(dls,-1);
        
        int res[] = new int[2];
        
        for(int i = 0 ; i < n ; i++){
            int idx = arr[i].deadline-1;    // -1 for 0 based indexing
            while(idx >= 0 && dls[idx] != -1){
                idx--;
            }
            if(idx < 0){
                continue;
            }
            dls[idx] = arr[i].id;
            res[0]++;
            res[1] += arr[i].profit;
        }
        
        return res;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int k){
        
        
        //Memoization ....
//         int dp[][] = new int[n][k+1];
//         for(int row[] : dp){
//             Arrays.fill(row,-1);
//         }
//         return sset(n-1,k,arr,dp);
        
        
        
        
        
        // Tabulation ...
        
        boolean dp[][] = new boolean[n][k+1];
        
        for(int index= 0 ; index < n ; index++){
            dp[index][0] = true;
        }
        
        if(arr[0]<=k) dp[0][arr[0]] = true;
        
        for(int index=1 ; index<n ; index++){
            for(int target=1 ; target<=k ; target++){
                boolean pick = false;
                if(arr[index] <= target)
                    pick = dp[index-1][target-arr[index]];
                boolean notPick = dp[index-1][target];

                dp[index][target] = pick|notPick;
            }
        }
        return dp[n-1][k];
        
        
        
        
        // Tabulation Space Optimized ...
        
        // boolean cur[] = new boolean[k+1];
        // boolean prev[] = new boolean[k+1];
        
        // for(int index= 0 ; index < n ; index++){
        //     prev[0] = true;
        // }
        
        // if(arr[0]<=k) prev[arr[0]] = true;
        
        // for(int index=1 ; index<n ; index++){
        //     for(int target=1 ; target<=k ; target++){
        //         boolean pick = false;
        //         if(arr[index] <= target)
        //             pick = prev[target-arr[index]];
        //         boolean notPick = prev[target];

        //         cur[target] = pick|notPick;
        //     }
        //     prev = cur.clone();
        // }
        // return prev[k];
        
    }
    public static boolean sset(int index,int target,int arr[], int dp[][]){
        // Momoization...
        
        if(target==0){
            return true;
        }
        if(index==0){
            return arr[0]==target;
        }
        if(dp[index][target] != -1)
            return dp[index][target]==1?true:false;
        
        boolean pick = false;
        if(arr[index] <= target)
            pick = sset(index-1,target-arr[index],arr,dp);
        boolean notPick = sset(index-1,target,arr,dp);
        
        dp[index][target] = pick|notPick?1:0;
        return pick|notPick;
        
        
        
        
        
        // Recursion ...
        
//         if(target==0){
//             return true;
//         }
//         if(index==0){
//             return arr[0]==target;
//         }
//         boolean pick = sset(index-1,target-arr[index],arr);
//         boolean notPick = sset(index-1,target,arr);
        
//         return pick|notPick;
        
    }
}

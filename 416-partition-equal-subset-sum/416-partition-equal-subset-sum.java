
class Solution {
    public boolean canPartition(int[] nums) {
        int totSum  = 0;
        for(int i : nums){
            totSum+=i;
        }
        int s1 = totSum/2;
        
        if(totSum % 2 != 0)
            return false;
        
        return isSubsetSum(nums.length, nums,s1);
    }
    
    
    
    static Boolean isSubsetSum(int n, int arr[], int k){
        
        
        //Memoization ....
        
        // int dp[][] = new int[n][k+1];
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return sset(n-1,k,arr,dp);
        
        
        
        
        
        // Tabulation ...
        
        // boolean dp[][] = new boolean[n][k+1];
        
        // for(int index= 0 ; index < n ; index++){
        //     dp[index][0] = true;
        // }
        
        // if(arr[0]<=k) dp[0][arr[0]] = true;
        
        // for(int index=1 ; index<n ; index++){
        //     for(int target=1 ; target<=k ; target++){
        //         boolean pick = false;
        //         if(arr[index] <= target)
        //             pick = dp[index-1][target-arr[index]];
        //         boolean notPick = dp[index-1][target];

        //         dp[index][target] = pick|notPick;
        //     }
        // }
        // return dp[n-1][k];
        
        
        
        
        // Tabulation Space Optimized ... O(k+1)
        
        boolean cur[] = new boolean[k+1];
        boolean prev[] = new boolean[k+1];
        
        for(int index= 0 ; index < n ; index++){
            prev[0] = true;
        }
        
        if(arr[0]<=k) prev[arr[0]] = true;
        
        for(int index=1 ; index<n ; index++){
            for(int target=1 ; target<=k ; target++){
                boolean pick = false;
                if(arr[index] <= target)
                    pick = prev[target-arr[index]];
                boolean notPick = prev[target];

                cur[target] = pick|notPick;
            }
            prev = cur.clone();
        }
        return prev[k];
        
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
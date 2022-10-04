class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        //return countPartitions(n,target,arr);
        
        
        // Recursion ... No momoization or tabulation is possile due to negative targets
        return countTargetSum(n-1,target,arr);
        
        
        
        
        
    }
    public static int countTargetSum(int index,int target ,int arr[]){
        if(index==0){
            if(target==0 && arr[0]==0)
                return 2;
            if(arr[0]==target || arr[0] == -1*(target) ){
                return 1;
            }
            return 0;
        }
        int plus = countTargetSum(index-1,target+arr[index],arr);
        int minus = countTargetSum(index-1,target-arr[index],arr);
        
        return plus+minus;
    }
    
    
    
    public static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for(int i : arr)
            totSum+=i;
        if( (totSum-d)<0 || (totSum-d)%2!=0 ) // sum of subset can't be in decimal or -ve coz given nubmers are greater than or equal to 0
            return 0;
        int s1 = (totSum-d)/2;
        
        // Memoization ...
        
//         int dp[][] = new int[n][s1+1];
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
//         return nsswsk(n-1,s1,arr,dp);
        
        
        
        
        // Tabulation ....
        int target = s1;
        
        int dp[][] = new int[n][target+1];
   
        if(arr[0]==0){
            dp[0][0] = 2;
        }else{
            dp[0][0] =1;
        }
        if(arr[0]!=0 && arr[0]<=target)
            dp[0][arr[0]] = 1;
        
        for(int index = 1 ; index<n ; index++){
            for(int t = 0 ; t <= target ; t++){
                int pick = 0;
                if(arr[index]<=t){
                    pick = dp[index-1][t-arr[index]];
                }
                int notPick = dp[index-1][t];

                dp[index][t] = (pick+notPick);
            }
        }
        
        return dp[n-1][target];
    }
    public static int nsswsk(int index,int target,int arr[],int dp[][]){
        if(index==0){
            if(arr[0]==0 && target==0)
                return 2;
            if(target==0 || arr[0]==target)
                return 1;
            return 0;
        }
        
        if(dp[index][target] != -1)
               return dp[index][target];
        
        int pick = 0;
        if(arr[index]<=target){
            pick = nsswsk(index-1,target-arr[index],arr,dp);
        }
        int notPick = nsswsk(index-1,target,arr,dp);
        
        return dp[index][target] = (pick+notPick);
    }
}
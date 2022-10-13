class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        
//        Tabulation....(Algorithm)...
        
        int dp[] = new int[n]; 
        Arrays.fill(dp,1);
        
        int maxi = Integer.MIN_VALUE;
        for(int index = 0 ; index < n ; index++){
            for(int prev_ind = 0 ; prev_ind < index ; prev_ind++){
                if(nums[index]>nums[prev_ind]){
                    dp[index] = Math.max(dp[index],1 + dp[prev_ind]);
                }
                
            }
            maxi = Math.max(maxi,dp[index]);
        }
        
        return maxi;
        
        
        
        
        
        
        
        
        
        
        // Printing the LIS...
        
//         int dp[] = new int[n];
//         int hash[] = new int[n];
        
//         Arrays.fill(dp,1);
        
//         int maxi = Integer.MIN_VALUE;
//         int lastInd = 0;
        
//         for(int index = 0 ; index < n ; index++){
//             hash[index] = index;
//             for(int prev = 0 ; prev < index ; prev++){
//                 if(nums[index]>nums[prev] && dp[prev]+1 > dp[index]){
//                     dp[index] = dp[prev]+1;
//                     hash[index] = prev;
//                 }
//             }
//             if(maxi < dp[index]){
//                 maxi = dp[index];
//                 lastInd = index;
//             }
//         }
        
//         ArrayList<Integer> arr = new ArrayList<>();
        
//         while(hash[lastInd] != lastInd){            
//             lastInd = hash[lastInd];
//             arr.add(nums[lastInd]);
//         }
        
//         // LIS is stored in reverse order...
        
//         for(int ele : arr){
//             System.out.print(ele+"  ");
//         }
        
//         System.out.println();
//         return maxi;
        
        
        //Tabulation....
        
//         int cur[] = new int[n+1];
//         int next[] = new int[n+1];
        
//         for(int index = n-1; index >=0 ; index--){
//             for(int prev_ind = index-1 ; prev_ind >= -1 ; prev_ind--){
//                 int take = 0;
//                 if(prev_ind==-1 || nums[index]>nums[prev_ind]){
//                     take = 1 + next[index+1];
//                 }
//                 int notTake = next[prev_ind+1];

//                 cur[prev_ind+1] = Math.max(take,notTake);
//             }
//             next = cur.clone();
//         }
        
//         return next[-1+1];
        
        
        
        //Tabulation....
        
//         int dp[][] = new int[n+1][n+1];
        
//         for(int index = n-1; index >=0 ; index--){
//             for(int prev_ind = index-1 ; prev_ind >= -1 ; prev_ind--){
//                 int take = 0;
//                 if(prev_ind==-1 || nums[index]>nums[prev_ind]){
//                     take = 1 + dp[index+1][index+1];
//                 }
//                 int notTake = dp[index+1][prev_ind+1];

//                 dp[index][prev_ind+1] = Math.max(take,notTake);
//             }
//         }
        
//         return dp[0][-1+1];
        
        
        
        //Memoization....
        
//         int dp[][] = new int[n][n+1];
        
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return lis(0,-1,nums,dp);
    }
    public static int lis(int index, int prev_ind,int nums[],int dp[][]){
        
        if(index==nums.length)
            return 0;
        
        if(dp[index][prev_ind+1] != -1)
            return dp[index][prev_ind+1];
        
        int take = 0;
        if(prev_ind==-1 || nums[index]>nums[prev_ind]){
            take = 1 + lis(index+1,index,nums,dp);
        }
        int notTake = lis(index+1,prev_ind,nums,dp);
        
        return dp[index][prev_ind+1] = Math.max(take,notTake);
        
        
        
        
        // Recursion...
        
//         if(index==nums.length)
//             return 0;
        
//         int take = 0;
//         if(prev_ind==-1 || nums[index]>nums[prev_ind]){
//             take = 1 + lis(index+1,index,nums);
//         }
//         int notTake = lis(index+1,prev_ind,nums);
        
//         return Math.max(take,notTake);
    }
}
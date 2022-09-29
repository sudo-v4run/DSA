class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
    
        int dp2[] = new int[n];
        Arrays.fill(dp2,-1);
        
        if(n==1)
            return nums[0];
        
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];
        int k=0 , l=0;
        for(int i = 0 ; i < n ; i++){
            if(i!=0){
                temp1[k++] = nums[i]; 
            }
            if(i!=(n-1)){
                temp2[l++] = nums[i];
            }
        }
        
        return Math.max(hr(temp1.length-1,temp1,dp),hr(temp2.length-1,temp2,dp2));
    }
    public int hr(int index , int arr[] , int dp[]){
        if(index<0)
            return 0;
        if(index==0){
            return arr[0];
        }
        
        if(dp[index]!=-1)
            return dp[index];
        
        int takeThis = arr[index] + hr(index-2,arr,dp);
        int notTake = 0 + hr(index-1, arr, dp);
        return dp[index] = Math.max(takeThis,notTake);
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n==1)
            return nums[0];
        
        return Math.max(hr(1,n,nums),hr(0,n-1,nums));
    }
    public int hr(int low , int hi , int arr[]){
        int prev1 = arr[low];
        int prev2 = 0;
        
        for(int i = low+1 ; i < hi ; i++){
            int takeThis = arr[i];
            if(i>1)
                takeThis += prev2;
            
            int notTake = 0 + prev1;
            
            int curi = Math.max(takeThis,notTake);
            
            prev2 = prev1;
            prev1 = curi;
        }
        
        return prev1;
    }
}
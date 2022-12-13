class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // TC - O(N) and SC - O(1) ...
        
        int res[] = new int[n];
        
        res[0] = 1;
        
        for(int i = 1; i < n ; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        
        int post = 1;
        
        for(int i = n-1 ; i >=0 ; i--){
            res[i] = res[i]*post;
            post = post*nums[i];
        }
        
        return res;
        
        
        
        
        
        // TC - O(N) and SC - O(2N) ...
        
        
//         int prefix[] = new int[n];
//         int suffix[] = new int[n];
        
//         prefix[0] = nums[0];
        
//         for(int i = 1 ; i < n ; i++){
//             prefix[i] = prefix[i-1]*nums[i];
//         }
        
//         suffix[n-1] = nums[n-1];
        
//         for(int i = n-2 ; i >=0 ; i--){
//             suffix[i] = nums[i]*suffix[i+1];
//         }
        
//         int res[] = new int[n];
        
//         res[0] = suffix[1];
//         res[n-1] = prefix[n-2];
        
//         for(int i = 1 ; i <= n-2 ; i++){
//             res[i] = prefix[i-1] * suffix[i+1];
//         }
        
//         return res;
    }
}
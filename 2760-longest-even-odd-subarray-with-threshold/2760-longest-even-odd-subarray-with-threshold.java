class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int n = nums.length;
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            int cnt = 1;
            int j = i;
            for( ; j < n-1 ; j++){
                
                if(nums[j] > threshold || 
                   nums[j] % 2 == nums[j + 1] % 2){
                    
                    break;
                }
                cnt++;
            }
            if(nums[i] % 2 != 0){
                cnt--;
            }
            if(nums[j] > threshold){
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        
        return ans;
    }
}
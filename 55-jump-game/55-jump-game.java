class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n-1;
        int i = n-2;
        while(i>=0){
            if(nums[i]+i>=goal)
                goal = i;
            
            i--;
        }
        
        return goal==0;
    }
}
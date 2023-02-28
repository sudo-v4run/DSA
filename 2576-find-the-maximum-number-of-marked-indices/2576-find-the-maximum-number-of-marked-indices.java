class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int i = 0;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int j = (n/2) ; i<(n/2) && j < n ; j++){
            
            if(2*nums[i] <= nums[j]){
                i++;
            }
        }
        
        return 2*i;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int ele : nums){
            hs.add(ele);
        }
        
        int maxL = 0;
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            if(!hs.contains(nums[i]-1)){
                int start = nums[i];
                int cnt = 0;
                
                while(hs.contains(start)){
                    cnt++;
                    start++;
                }
                maxL = Math.max(maxL,cnt);
            }
        }
        
        return maxL;
    }
}
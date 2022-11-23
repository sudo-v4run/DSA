class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int maxL = 0;
        
        for(int i : nums){
            hs.add(i);
        }
        
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            if(hs.contains(nums[i]-1))
                continue;
            int cnt = 1;
            int st = nums[i]+1;
            while(hs.contains(st)){
                cnt++;
                st++;
            }
            maxL = Math.max(maxL,cnt);
        }
        
        return maxL;
    }
}
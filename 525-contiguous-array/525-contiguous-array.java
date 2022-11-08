class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        int maxL = 0;
        int n = nums.length;
        int curSum = 0;
        
        for(int i = 0 ; i < n ; i++){
            nums[i] = nums[i]==0?-1:nums[i];
        }
        
        for(int i = 0 ; i < n ; i++){
            curSum+=nums[i];
            if(hm.containsKey(curSum)){
                int start = hm.get(curSum);
                int end = i;
                maxL = Math.max(maxL,end-start);
            }else{
                hm.put(curSum,i);
            }
        }
        
        return maxL;
    }
}
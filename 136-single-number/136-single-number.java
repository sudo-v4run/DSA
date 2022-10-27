class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>(10);
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }else{
                hs.remove(nums[i]);
            }
        }
        
        for(int e : hs){
            return e;
        }
        
        return 0;
    }
}
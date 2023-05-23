class Solution {
    public int singleNumber(int[] nums) {
        
        int xor = 0;
        
        for(int i : nums){
            xor^=i;
        }
        
        return xor;
        
        
//         HashSet<Integer> hs = new HashSet<>(10);
        
//         for(int i = 0 ; i < nums.length ; i++){
//             if(!hs.contains(nums[i])){
//                 hs.add(nums[i]);
//             }else{
//                 hs.remove(nums[i]);
//             }
//         }
//         int ans = 0;
//         for(int e : hs){
//             ans = e;
//             break;
//         }
        
//         return ans;
    }
}
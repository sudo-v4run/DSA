class Solution {
    public int missingNumber(int[] nums) {
        
//         int xor = 0;
//         int i =0;
        
//         for( ; i < nums.length ; i++){
//             xor = xor ^ i ^ nums[i];
//         }
        
//         return xor ^ i;
        
             
        int n = nums.length;
        int Nsum  = (n*(n+1)) / 2;
        int totSum = 0;
        for(int i : nums){
            totSum+=i;
        }
        
        return Nsum-totSum;
    }
}
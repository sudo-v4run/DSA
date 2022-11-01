class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int xor = 0;
        int i = 0;
        
        for( ; i < n ; i++){
            xor = xor ^ i ^ nums[i];
        }
        
        return xor ^ i;
        
        
                     

//         int Nsum  = (n*(n+1)) / 2;
        
//         for(int i : nums){
//             Nsum-=i;
//         }
        
//         return Nsum;
        
        
        
        

//         int Nsum  = (n*(n+1)) / 2;
//         int totSum = 0;
//         for(int i : nums){
//             totSum+=i;
//         }
        
//         return Nsum-totSum;
    }
}
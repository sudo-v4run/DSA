class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int Nsum  = (n*(n+1)) / 2;
        int totSum = 0;
        for(int i : nums){
            totSum+=i;
        }
        
        return Nsum-totSum;
    }
}
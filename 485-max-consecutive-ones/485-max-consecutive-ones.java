class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0 ;
        int result = 0;
        
        for(int i : nums){
            if(i==0){
                cnt = 0;
            }else{
                cnt++;
                result = Math.max(result,cnt);
            }
        }
        return result;
    }
}
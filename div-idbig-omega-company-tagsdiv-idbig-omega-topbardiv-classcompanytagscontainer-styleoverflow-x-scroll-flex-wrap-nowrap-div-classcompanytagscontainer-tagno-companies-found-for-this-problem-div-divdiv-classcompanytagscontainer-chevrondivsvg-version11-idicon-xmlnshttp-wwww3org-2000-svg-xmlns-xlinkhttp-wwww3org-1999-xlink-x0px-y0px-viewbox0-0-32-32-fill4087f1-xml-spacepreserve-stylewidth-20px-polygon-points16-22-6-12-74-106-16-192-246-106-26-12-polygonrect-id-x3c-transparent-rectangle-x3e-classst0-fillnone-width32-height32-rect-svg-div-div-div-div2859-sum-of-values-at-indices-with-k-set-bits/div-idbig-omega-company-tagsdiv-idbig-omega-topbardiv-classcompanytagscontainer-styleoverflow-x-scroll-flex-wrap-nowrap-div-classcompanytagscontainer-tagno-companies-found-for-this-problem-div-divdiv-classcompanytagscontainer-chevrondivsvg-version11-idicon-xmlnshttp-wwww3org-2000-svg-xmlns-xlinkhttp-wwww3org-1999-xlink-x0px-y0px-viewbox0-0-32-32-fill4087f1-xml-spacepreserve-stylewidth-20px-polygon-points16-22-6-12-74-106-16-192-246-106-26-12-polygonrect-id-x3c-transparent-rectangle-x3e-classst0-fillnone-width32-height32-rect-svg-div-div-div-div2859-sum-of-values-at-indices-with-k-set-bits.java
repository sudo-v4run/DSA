class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        
        int n = nums.size();
        int sum = 0;
        
        for(int i = 0 ; i < n ; i++){
            int cnt = countBits(i);
            if(cnt == k){
                sum += nums.get(i);
            }
        }
        
        return sum;
    }
    public static int countBits(int x){
        
        int cnt = 0;
        
        while(x != 0){
            
            cnt++;
            x = x&(x-1);
        }
        
        return cnt;
    }
}
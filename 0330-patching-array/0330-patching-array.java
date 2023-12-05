class Solution {
    public int minPatches(int[] arr, int n) {
        
        long preSum = 0;
        int cnt = 0;
        int i = 0;
        
        for(long t = 1 ; t <= n ; t++){
            if(i < arr.length && arr[i] <= t){
                preSum += arr[i];
                i++;
            }else{
                if(preSum >= t){
                    t = preSum;
                    continue;
                }
                cnt++;
                preSum += t;
            }
        }
        
        return cnt;
    }
}
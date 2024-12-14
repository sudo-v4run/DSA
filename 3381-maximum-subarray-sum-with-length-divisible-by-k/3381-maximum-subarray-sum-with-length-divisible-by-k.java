class Solution {
    public long maxSubarraySum(int[] arr, int k) {
        
        int n = arr.length;
        
        long pre[] = new long[n+1];
        pre[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            pre[i] = pre[i-1] + arr[i-1];
        }
        
        long minPreSum[] = new long[n+1];
        Arrays.fill(minPreSum,(long)1e15);
        minPreSum[0] = 0;
        
        long max = Long.MIN_VALUE;
        
        for(int i = 1 ; i <= n ; i++){
            
            max = Math.max(max,pre[i]-minPreSum[i%k]);
            
            minPreSum[i%k] = Math.min(minPreSum[i%k],pre[i]);
        }
        
        return max;
    }
}
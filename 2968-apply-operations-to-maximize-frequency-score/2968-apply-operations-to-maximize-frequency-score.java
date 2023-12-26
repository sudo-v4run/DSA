class Solution {
    long preSum[];
    public int maxFrequencyScore(int[] arr, long k) {
        
        int n = arr.length;
        Arrays.sort(arr);
        
        preSum = new long[n];
        preSum[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            preSum[i] = preSum[i-1]+arr[i];
        }
        
        int l = 1;
        int h = n;
        int ans = 0;
        while(l <= h){
            
            int mid = l+(h-l)/2;
            
            if(isPossible(mid,k,arr)){
                ans = mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        
        return ans;
    }
    public boolean isPossible(int winLen, long k, int arr[]){
        
        int n = arr.length;
        
        int i = 0;
        int j = 0;
        while(j<n){
            if(j-i+1 == winLen){
                
                int medianInd = (i+j)/2;
                int median = arr[medianInd];
                
                long lOps = ((medianInd-i+1)*1L*median) - (preSum[medianInd]-preSum[i]+arr[i]);
                long rOps = (preSum[j]-preSum[medianInd]) - ((j-medianInd)*1L*median);
                
                long totOps = lOps + rOps;
                if(totOps <= k){
                    return true;
                }
                
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return false;
    }
}
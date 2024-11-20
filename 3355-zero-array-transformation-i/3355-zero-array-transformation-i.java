class Solution {
    public boolean isZeroArray(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        int freq[] = new int[n+1];
        
        for(int q[] : queries){
            freq[q[0]]++;
            freq[q[1]+1]--;
        }
        
        int preSum[] = new int[n+1];
        preSum[0] = freq[0];
        
        for(int i = 1 ; i < freq.length ; i++){
            preSum[i] = preSum[i-1] + freq[i];
        }
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > preSum[i]){
                return false;
            }
        }
        
        return true;
    }
}
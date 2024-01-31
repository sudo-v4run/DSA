class Solution {
    public int minMoves2(int[] arr) {
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        int medianIndex = n/2;
        int median = arr[n/2];
        
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            ans += Math.abs(median-arr[i]);
        }
        
        return ans;
    }
}
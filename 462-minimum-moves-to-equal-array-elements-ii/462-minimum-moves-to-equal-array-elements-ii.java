class Solution {
    public int minMoves2(int[] arr) {
        
        Arrays.sort(arr);
        
        int n = arr.length;
        
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int medianIndex = n/2;
        int median = arr[n/2];
        
        int left = ((medianIndex-0+1)*median) - prefix[medianIndex];
        int right = (prefix[n-1]-prefix[medianIndex]) - ((n-1-medianIndex)*median);
        
        return left+right;
    }
}
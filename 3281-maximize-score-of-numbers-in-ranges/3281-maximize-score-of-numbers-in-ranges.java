class Solution {
    public int maxPossibleScore(int[] start, int d) {
        
        int n = start.length;
        
        Arrays.sort(start);

        long lo = 0, hi = Long.MAX_VALUE;
        
        int ans = 0;

        while (lo <= hi) {
            
            long mid = lo + (hi - lo) / 2;

            if (isPossible(start, d, mid)) {
                ans = (int) mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
    private boolean isPossible(int[] arr, int d, long mid) {
        
        int n = arr.length;
        
        long prev = arr[0];

        for (int i = 1 ; i < n ; i++) {
            
            long min = prev + mid;

            if (min > arr[i] + d) {
                return false;
            }

            prev = Math.max(arr[i], min);
        }

        return true;
    }
}
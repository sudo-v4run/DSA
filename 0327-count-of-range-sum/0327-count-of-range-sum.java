class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return partition(sums, 0, n, lower, upper);
    }

    public static int partition(long arr[], int l, int h, int lower, int upper) {
        if (l < h) {
            int m = (l + h) / 2;
            int count = partition(arr, l, m, lower, upper);
            count += partition(arr, m + 1, h, lower, upper);
            count += merge(arr, l, m, h, lower, upper);
            return count;
        }
        return 0;
    }

    public static int merge(long arr[], int l, int m, int r, int lower, int upper) {
        // Count valid range sums
        int count = 0;
        int j = m + 1;
        int k = m + 1;
        
        for (int i = l; i <= m; i++) {
            // Find the range [k, j) where lower <= arr[j] - arr[i] <= upper
            while (k <= r && arr[k] - arr[i] < lower) k++;
            while (j <= r && arr[j] - arr[i] <= upper) j++;
            count += j - k;
        }
        
        // Standard merge sort logic
        int n = r - l + 1;
        long res[] = new long[n];
        int i = l;
        j = m + 1;
        int idx = 0;
        
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                res[idx++] = arr[i++];
            } else {
                res[idx++] = arr[j++];
            }
        }
        
        while (i <= m) {
            res[idx++] = arr[i++];
        }
        
        while (j <= r) {
            res[idx++] = arr[j++];
        }
        
        // Copy back
        i = l;
        idx = 0;
        for (; i <= r; i++) {
            arr[i] = res[idx++];
        }
        
        return count;
    }
}
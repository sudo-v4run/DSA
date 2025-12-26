class Solution {
    static int res;
    public int countRangeSum(int[] nums, int lower, int upper) {
        res = 0;
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];

        
        partition(sums, 0, n, lower, upper);

        return res;
    }

    public static void partition(long arr[], int l, int h, int lower, int upper) {
        if (l < h) {
            int m = (l + h) / 2;
            partition(arr, l, m, lower, upper);
            partition(arr, m + 1, h, lower, upper);
            res += merge(arr, l, m, h, lower, upper);
        }
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
        long temp[] = new long[n];
        int i = l;
        j = m + 1;
        int idx = 0;
        
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        
        while (i <= m) {
            temp[idx++] = arr[i++];
        }
        
        while (j <= r) {
            temp[idx++] = arr[j++];
        }
        
        // Copy back
        idx = 0;
        for (int index = l ; index <= r; index++) {
            arr[index] = temp[idx++];
        }
        
        return count;
    }
}
class Solution {
    public int subarraySum(int[] arr) {
        
        int n = arr.length;

        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            int start = Math.max(0,i-arr[i]);
            int sum = 0;
            for(int j = start ; j <= i ; j++){
                sum += arr[j];
            }
            ans += sum;
        }

        return ans;
    }
}
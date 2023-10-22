class Solution {
    public int minimumSum(int[] arr) {
        
        int n = arr.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        
        for(int i = 1 ; i < n ; i++){
            left[i] = Math.min(left[i-1],arr[i-1]);
        }
        
        for(int i = n-2 ; i >= 0 ; i--){
            right[i] = Math.min(right[i+1],arr[i+1]);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(left[i] < arr[i] && arr[i] > right[i]){
                ans = Math.min(ans,left[i]+arr[i]+right[i]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
class Solution {
    public long maximumTripletValue(int[] arr) {
        
        int n = arr.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        
        for(int i = 1 ; i < n ; i++){
            left[i] = Math.max(arr[i-1],left[i-1]);
        }
        
        for(int i = n-2 ; i >=0 ; i--){
            right[i] = Math.max(arr[i+1],right[i+1]);
        }
        
        long ans = 0;
        
        for(int i = 1 ; i < n-1 ; i++){
            long temp = (left[i]-arr[i])*1l*right[i];
            ans = Math.max(ans,temp);
        }
        
        return ans;
    }
}
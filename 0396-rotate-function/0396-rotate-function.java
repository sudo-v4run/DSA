class Solution {
    public int maxRotateFunction(int[] arr) {
        
        int n = arr.length;
        
        int sum = 0;
        int f0 = 0;
        
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            f0 += i*arr[i];
        }
        
        int max = f0;
        
        int prev = f0;
        
        int j = n-1;
        
        for(int i = 1 ; i < n ; i++){
            
            // int cur = f0+sum-(n*arr[n-1-(i-1)]);
            
            int cur = prev+sum-(n*arr[j]);
            j--;
            max = Math.max(max,cur);
            prev = cur;
        }
        
        return max;
    }
}
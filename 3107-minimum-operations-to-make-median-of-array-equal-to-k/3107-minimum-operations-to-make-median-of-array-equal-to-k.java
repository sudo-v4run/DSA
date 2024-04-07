class Solution {
    public long minOperationsToMakeMedianK(int[] arr, int k) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        int median = arr[n / 2];
        
        if(median == k){
            return 0;
        }
        
        long ops = 0;
        
        if(k < median){
            for(int i = n/2 ; i >= 0 ; i--){
                if(arr[i] > k){
                    ops += arr[i]-k;
                }else{
                    break;
                }
            }
        }else{
            for(int i = n/2 ; i < n ; i++){
                if(arr[i] < k){
                    ops += k-arr[i];
                }else{
                    break;
                }
            }
        }
        
        return ops;
    }
}
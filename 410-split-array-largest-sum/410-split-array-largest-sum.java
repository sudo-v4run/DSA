class Solution {
    public int splitArray(int[] arr, int k) {
        
        int n = arr.length;
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i : arr){
            if(i < min){
                min = i;
            }
            sum += i;
        }
        
        int lo = min;
        int hi = sum;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(isPossible(mid,k,arr)){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    public static boolean isPossible(int maxSum, int k, int arr[]){
        
        int n = arr.length;
        
        if(arr[0] > maxSum){
            return false;
        }
        
        int sum = arr[0];
        int cnt = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > maxSum){
                return false;
            }
            if(sum + arr[i] <= maxSum){
                sum += arr[i];
            }else{
                cnt++;
                sum = arr[i];
            }
        }
        
        return cnt <= k;
    }
}
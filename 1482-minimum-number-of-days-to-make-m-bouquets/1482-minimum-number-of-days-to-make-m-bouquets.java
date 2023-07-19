class Solution {
    public int minDays(int[] arr, int m, int k) {
        
        int n = arr.length;
        
        if(n < (m*k)){
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        int max = -1;
        
        for(int i : arr){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }
        
        int lo = min;
        int hi = max;
        
        int ans = -1;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(arr,mid,m,k)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public static boolean isPossible(int arr[], int day, int m, int k){
        int n = arr.length;
        int cnt = 0;
        int bouquets = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= day){
                cnt++;
            }else{
                bouquets += cnt/k;
                cnt = 0;
            }
        }
        bouquets += cnt/k;
        
        return bouquets >= m;
    }
}
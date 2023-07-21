class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int low = -1;
        int high = 0;
        
        for(int i : weights){
            low = Math.max(low,i);
        }
        for(int i : weights){
            high += i;
        }
        
        
        int ans = -1;
        
        int lo = low;
        int hi = high;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(weights,mid,days)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    public static boolean isPossible(int arr[], int capacity, int days){
        
        int n = arr.length;
        
        int load = 0;
        int dayCnt = 1;
        
        for(int i = 0 ; i < n ; i++){
            if(load+arr[i] <= capacity){
                load += arr[i];
            }else{
                dayCnt++;
                load = arr[i];
            }
        }
        
        return dayCnt <= days;
    }
}
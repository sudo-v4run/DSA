class Solution {
    public int incremovableSubarrayCount(int[] arr) {
        
        int n = arr.length;
        
        int max_l = 0;
        while(max_l+1 < n){
            if(arr[max_l+1] > arr[max_l]){
                max_l++;
            }else{
                break;
            }
        }
        
        int min_r = n-1;
        while(min_r-1 >= 0){
            if(arr[min_r-1] < arr[min_r]){
                min_r--;
            }else{
                break;
            }
        }
        
        int cnt = 0;
        
        for(int l = -1 ; l <= max_l ; l++){
            int cur = l == -1 ? Integer.MIN_VALUE : arr[l];
            int index = bs(min_r,n-1,cur,arr);
            if(max_l  == n-1){
                cnt += n-index;
            }else{
                cnt += n-index+1;
            }
        }
        
        return cnt;
    }
    public int bs(int l, int h, int target, int arr[]){
        
        int ans = arr.length;
        
        int lo = l;
        int hi = h;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(target < arr[mid]){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}
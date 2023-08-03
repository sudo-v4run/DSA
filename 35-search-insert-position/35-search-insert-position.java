class Solution {
    public int searchInsert(int[] arr, int target) {
        
        int n = arr.length;
        
        int lo = 0;
        int hi = n-1;
        
        int ans = n;    // if the ele is to inserted at the end (nth index)..
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid] == target){
                return mid;
            }
            
            if(arr[mid] < target){
                lo = mid+1;
            }else{
                ans = mid;
                hi = mid-1;
            }
        }
        
        return ans;         // can simply return lo (low) also...
    }
}
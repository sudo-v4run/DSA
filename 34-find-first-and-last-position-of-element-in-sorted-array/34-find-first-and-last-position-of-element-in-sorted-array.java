class Solution {
    public int[] searchRange(int[] arr, int target) {
        int ans[] = {-1,-1};
        
        ans[0] = bs(arr,target,true);
        if(ans[0] != -1){
            ans[1] = bs(arr,target,false);
        }
        
        return ans;
    }
    public static int bs(int arr[], int x, boolean find1stIndex){
        int ans = -1;
        
        int s = 0;
        int e = arr.length-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(x<arr[mid]){
                e  = mid-1;
            }else if(arr[mid]<x){
                s = mid+1;
            }else{
                ans = mid;
                if(find1stIndex){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }
        }
        
        return ans;
    }
}
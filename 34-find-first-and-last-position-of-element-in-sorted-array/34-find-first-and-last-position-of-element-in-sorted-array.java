class Solution {
    public int[] searchRange(int[] arr, int target) {
        int res[] = {-1,-1};
        int first = bs(arr,target,true);
        int last = bs(arr,target,false);
        
        res[0] = first;
        res[1] = last;
        
        return res;
    }
    public static int bs(int arr[],int target,boolean forFirst){
        int ans = -1;
        
        int s = 0;
        int e = arr.length-1;
        
        while(s<=e){
            int m = s+(e-s)/2;
            
            if(arr[m]==target){
                ans = m;
                if(forFirst){
                    e = m-1;
                }else{
                    s = m+1;
                }
            }else if(target<arr[m]){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        
        return ans;
    }
}
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        
        int s = 0;
        int e = n-1;
        
        while(s<e){
            int m = s+(e-s)/2;
            
            if(arr[m]<arr[m+1]){
                s = m+1;
            }else{
                e = m;
            }
        }
        
        return s;
    }
}
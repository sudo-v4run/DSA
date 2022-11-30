class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        
        while(s<e){
            int m = s+(e-s)/2;
            
            if(m==0){
                if(arr[m]>arr[m+1])
                    return m;
                return m+1;
            }
            
            if(arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return m;
            }
            
            if(arr[m]<arr[m+1]){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        
        return e;
    }
}
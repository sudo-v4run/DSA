class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        
        int max = -1;
        for(int i : arr){
            max = Math.max(max,i);
        }
        
        int lo = 1;
        int hi = max;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(sum(arr,mid) <= threshold){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    public static int sum(int arr[], int d){
        
        int sum = 0;
        
        for(int i : arr){
            sum += i/d;
            if(i%d != 0){
                sum++;
            }
        }
        
        return sum;
    }
}
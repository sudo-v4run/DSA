class Solution {
    public long countAlternatingSubarrays(int[] arr) {
        
        int n = arr.length;
        
        long cnt = 0;
        
        int i = 0;
        int j = 0;
        
        while(j < n){
            
            if(j-i+1 == 1 || arr[j] != arr[j-1]){
                cnt += j-i+1;
                j++;
            }else{
                i = j;
                cnt++;
                j++;
            }
        }
        
        return cnt;
    }
}
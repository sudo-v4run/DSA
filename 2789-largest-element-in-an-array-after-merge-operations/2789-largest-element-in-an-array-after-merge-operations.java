class Solution {
    public long maxArrayValue(int[] arr){
        
        int n = arr.length;
        long ans = 0;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(arr[i] <= ans){
                ans += arr[i];
            }else{
                ans = arr[i];
            }
        }
        
        return ans;
    }
}
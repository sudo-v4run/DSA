class Solution {
    public long countSubarrays(int[] arr, int k) {
        
        int n = arr.length;
        int max = -1;
        
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,arr[i]);
        }
        
        long ans = 0;
        int maxFreq = 0;
        
        int i = 0;
        int j = 0;
        
        while(j < n){
            if(arr[j] == max){
                maxFreq++;
            }
            
            while(maxFreq >= k){
                ans += n-j;
                if(arr[i] == max){
                    maxFreq--;
                }
                i++;
            }
            j++;
        }
        
        return ans;
    }
}
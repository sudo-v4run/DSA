class Solution {
    public int countMatchingSubarrays(int[] arr, int[] pattern) {
        
        int n = arr.length;
        int m = pattern.length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < n-m ; i++){
            
            boolean flag = true;
        
            for(int k = 0 ; k < m ; k++){
                
                if(pattern[k] == 1 && !(arr[i+k+1] > arr[i+k])){
                    flag = false;
                }else if(pattern[k] == 0 && !(arr[i+k+1] == arr[i+k])){
                    flag = false;
                }else if(pattern[k] == -1 && !(arr[i+k+1] < arr[i+k])){
                    flag = false;
                }
            }
            
            if(flag){
                cnt++;
            }
        }
        
        return cnt;
    }
}
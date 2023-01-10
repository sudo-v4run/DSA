class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i]<0){
                arr[i] = 0;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            int val = Math.abs(arr[i]);
            
            if(val-1 <0 || val-1 >= n){
                continue;
            }
            
            if(arr[val-1]>0){
                arr[val-1] = -arr[val-1];
            }else if(arr[val-1]==0){
                arr[val-1] = -(n+1);
            }
        }
        
        for(int i = 1; i <=n ; i++){
            if(!(arr[i-1]<0))
                return i;
        }
        
        return n+1;
    }
}
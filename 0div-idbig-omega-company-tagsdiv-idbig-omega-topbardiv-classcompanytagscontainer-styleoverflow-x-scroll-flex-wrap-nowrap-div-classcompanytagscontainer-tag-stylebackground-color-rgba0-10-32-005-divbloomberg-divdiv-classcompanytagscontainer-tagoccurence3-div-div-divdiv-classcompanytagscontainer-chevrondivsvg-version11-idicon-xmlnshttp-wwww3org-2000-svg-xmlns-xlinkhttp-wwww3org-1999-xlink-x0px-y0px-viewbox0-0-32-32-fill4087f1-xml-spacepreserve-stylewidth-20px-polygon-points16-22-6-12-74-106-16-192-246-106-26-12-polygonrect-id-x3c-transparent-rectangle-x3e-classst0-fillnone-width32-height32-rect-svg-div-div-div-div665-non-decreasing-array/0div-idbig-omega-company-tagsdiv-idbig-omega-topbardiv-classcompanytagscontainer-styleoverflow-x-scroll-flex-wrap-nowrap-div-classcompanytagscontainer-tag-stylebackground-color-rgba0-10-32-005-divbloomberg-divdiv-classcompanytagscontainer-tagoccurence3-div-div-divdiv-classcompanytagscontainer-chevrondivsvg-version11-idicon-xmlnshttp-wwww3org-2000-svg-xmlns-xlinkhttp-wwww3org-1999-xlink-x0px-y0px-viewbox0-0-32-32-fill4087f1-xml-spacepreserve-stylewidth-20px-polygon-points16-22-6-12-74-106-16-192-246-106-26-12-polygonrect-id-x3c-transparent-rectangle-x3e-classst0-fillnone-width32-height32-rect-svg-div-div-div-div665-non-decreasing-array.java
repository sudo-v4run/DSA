class Solution {
    public boolean checkPossibility(int[] arr) {
     
        int n = arr.length;
        boolean isChanged = false;
        
        for(int i = n-2 ; i >= 0 ; i--){
            if(arr[i] <= arr[i+1]){
                continue;
            }
            if(isChanged){
                return false;
            }
            
            if(i+2 <= n-1 && arr[i] > arr[i+2]){
                arr[i] = arr[i+1];
            }else{
                arr[i+1] = arr[i];
            }
            isChanged = true;
        }
        
        return true;
    }
}
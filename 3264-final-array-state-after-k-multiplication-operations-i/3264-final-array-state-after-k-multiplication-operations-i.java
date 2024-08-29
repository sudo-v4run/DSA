class Solution {
    public int[] getFinalState(int[] arr, int k, int multiplier) {
        
        int n = arr.length;
        
        for(int i = 0 ; i < k ; i++){
            int midInd = 0;
            for(int j = 0 ; j < n ; j++){
                if(arr[j] < arr[midInd]){
                    midInd = j;
                }
            }
            
            arr[midInd] = arr[midInd]*multiplier;
        }
        
        return arr;
    }
}
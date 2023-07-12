class Solution {
    public boolean checkArray(int[] arr, int k) {
        
        int n = arr.length;
        
        int impact = 0;
        int i = 0;
        int j = 0;
        
        while(j < n){
            
            arr[j] -= impact;
            if(arr[j] < 0){
                return false;
            }
            impact += arr[j];
            if(j >= k-1){
                impact -= arr[i];
                i++;
            }
            j++;
        }
        
        return impact == 0;
    }
}
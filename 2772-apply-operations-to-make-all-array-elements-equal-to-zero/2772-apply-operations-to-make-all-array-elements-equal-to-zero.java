class Solution {
    public boolean checkArray(int[] arr, int k) {
        
        int n = arr.length;
        
        int impact = 0;
        int i = 0;
        int j = 0;
        
        while(j < n){
            if(j-i+1 < k){
                arr[j] -= impact;
                if(arr[j] < 0){
                    return false;
                }
                impact += arr[j];
                j++;
            }else if(j-i+1 == k){
                arr[j] -= impact;
                if(arr[j] < 0){
                    return false;
                }
                impact += arr[j];
                impact -= arr[i];
                i++;
                j++;
            }
        }
        
        return impact == 0;
    }
}
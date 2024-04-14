class Solution {
    public int maximumPrimeDifference(int[] arr) {
        
        int n = arr.length;
        
        int l = -1;
        
        for(int i = 0 ; i < n ; i++){
            if(isPrime(arr[i])){
                l = i;
                break;
            }
        }
        
        int r = -1;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(isPrime(arr[i])){
                r = i;
                break;
            }
        }
        
        return r-l;
    }
    public boolean isPrime(int x){
        
        if(x <= 1){
            return false;
        }
        
        for(int i = 2 ; i < x ; i++){
            if(x%i == 0){
                return false;
            }
        }
        
        return true;
    }
}
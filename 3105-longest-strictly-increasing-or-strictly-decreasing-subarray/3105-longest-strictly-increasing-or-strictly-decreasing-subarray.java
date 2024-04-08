class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        
        int n = arr.length;
        
        int maxInc = 1;
        int maxDec = 1;
        
        int cntInc = 1;
        int cntDec = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > arr[i-1]){
                cntInc++;
            }else{
                cntInc = 1;
            }
            maxInc = Math.max(maxInc,cntInc);
            
            if(arr[i] < arr[i-1]){
                cntDec++;
            }else{
                cntDec = 1;
            }
            maxDec = Math.max(maxDec,cntDec);
        }
        
        return Math.max(maxInc,maxDec);
    }
}
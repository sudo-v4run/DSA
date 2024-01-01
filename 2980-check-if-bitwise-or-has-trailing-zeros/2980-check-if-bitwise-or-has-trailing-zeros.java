class Solution {
    public boolean hasTrailingZeros(int[] arr) {
        
        int n = arr.length;
        
        int evenCnt = 0;
        
        for(int i = 0; i < n ; i++){
            if(arr[i]%2 == 0){
                evenCnt++;
            }
        }
        
        return evenCnt >= 2;
    }
}
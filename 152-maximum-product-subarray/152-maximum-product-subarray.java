class Solution {
    public int maxProduct(int[] arr) {
        int maxP = Integer.MIN_VALUE;
        int curP = 1;
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            curP *= arr[i];
            maxP = Math.max(maxP,curP);
            if(curP==0){
                curP = 1;
            }
        }
        
        curP = 1;
        
        for(int i = n-1 ; i >=0 ; i--){
            curP *= arr[i];
            maxP = Math.max(maxP,curP);
            if(curP==0){
                curP = 1;
            }
        }
        
        return maxP;
    }
}
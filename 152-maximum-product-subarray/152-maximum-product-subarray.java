class Solution {
    public int maxProduct(int[] arr) {
        
//         int maxP = Integer.MIN_VALUE;
//         int curP = 1;
//         int n = arr.length;
        
//         for(int i = 0 ; i < n ; i++){
//             curP *= arr[i];
//             maxP = Math.max(maxP,curP);
//             if(curP==0){
//                 curP = 1;
//             }
//         }
        
//         curP = 1;
        
//         for(int i = n-1 ; i >=0 ; i--){
//             curP *= arr[i];
//             maxP = Math.max(maxP,curP);
//             if(curP==0){
//                 curP = 1;
//             }
//         }
        
//         return maxP;
        
        
        int n = arr.length;
        
        int max = Integer.MIN_VALUE;
        int pref = 1;
        int suf = 1;
        
        for(int i = 0 ; i < n ; i++){
            pref *= arr[i];
            suf *= arr[n-1-i];
            
            max = Math.max(max,Math.max(pref,suf));
            
            if(pref == 0){
                pref = 1;
            }
            if(suf == 0){
                suf = 1;
            }
        }
        
        return max;
    }
}
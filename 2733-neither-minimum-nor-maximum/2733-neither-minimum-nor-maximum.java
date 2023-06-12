class Solution {
    public int findNonMinOrMax(int[] arr) {
        
        int n = arr.length;
        
        if(n < 3){
            return -1;
        }
        
        int a = Math.min(arr[0],arr[1]);
        int b = Math.max(arr[0],arr[1]);
        int c = arr[2];
        
        if(c > a && c < b){
            return c;       // coz c is not min or max for sure...
        }
        if(c < a){
            return a;       // coz now a is not the min anymore...
        }
        if(c > b){
            return b;       // coz now b is not max anymore...
        }
        
        return -1;
        
        
        
//         int n = arr.length;
        
//         int min = Integer.MAX_VALUE;
//         int max = 0;
        
//         for(int i = 0 ; i < n ; i++){
//             if(arr[i] < min){
//                 min = arr[i];
//             }
//             if(arr[i] > max){
//                 max = arr[i];
//             }
//         }
        
//         for(int i = 0 ; i < n ; i++){
//             if(arr[i] != min && arr[i] != max){
//                 return arr[i];
//             }
//         }
        
//         return -1;
    }
}
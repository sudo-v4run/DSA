class Solution {
    public long minimumOperations(int[] arr, int[] target) {
        
        int n = arr.length;
        
        long cnt = 0;
        long plus = 0;
        long minus = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            if(arr[i] == target[i]){
                
                plus = 0;
                minus = 0;
            }else if(arr[i] < target[i]){
                
                minus = 0;
                int req = target[i]-arr[i];
                
                if(plus >= req){
                    plus = req;
                }else{
                    cnt += req-plus;
                    plus = req;
                }
            }else{
                
                plus = 0;
                int req = arr[i]-target[i];
                
                if(minus >= req){
                    minus = req;
                }else{
                    cnt += req-minus;
                    minus = req;
                }
            }
        }
        
        return cnt;
    }
}
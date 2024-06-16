class Solution {
    public int countCompleteDayPairs(int[] arr) {
        
        int n = arr.length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if((arr[i]+arr[j]) % 24 == 0){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
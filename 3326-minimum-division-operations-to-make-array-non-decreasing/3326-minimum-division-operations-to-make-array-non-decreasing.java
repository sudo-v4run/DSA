class Solution {
    public int minOperations(int[] arr) {
        
        int n = arr.length;
        int cnt = 0;

        for (int i = n - 2; i >= 0; i--) {
            
            if (arr[i] <= arr[i + 1]){
                continue;
            }

            int tempCnt = 0;
            int divisor = f(arr[i]);

            if (divisor <= 1){
                return -1;
            }

            cnt++;
            arr[i] = divisor;

            if (arr[i] > arr[i+1]){
                return -1;
            }
        }

        return cnt;
    }
    public int f(int x) {
        
        for(int i = 2 ; i <= (int)Math.sqrt(x) ; i++){
            
            if (x % i == 0) {
                
                if (i < x){
                    return i;
                }
            }
        }
        
        return 0;
    }
}
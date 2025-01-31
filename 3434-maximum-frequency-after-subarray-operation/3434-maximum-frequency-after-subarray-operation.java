class Solution {
    public int maxFrequency(int[] arr, int k) {
        
        int n = arr.length;

        int initialKFreq = 0;
        for(int x : arr){
            if(x == k){
                initialKFreq++;
            }
        }

        int max = 0;
        for(int i = 1 ; i <= 50 ; i++){
            int cur = 0;
            if(i == k){
                continue;
            }
            for(int j = 0 ; j < n ; j++){
                if(cur < 0){
                    cur = 0;
                }
                if(arr[j] == i){
                    cur++;
                }else if(arr[j] == k){
                    cur--;
                }
                
                max = Math.max(max,cur);
            }
        }

        return initialKFreq+max;
    }
}
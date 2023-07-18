class Solution {
    public int minimumIndex(List<Integer> arr) {
        
        int dominant = arr.get(0);
        int cnt = 0;
        
        for(int i : arr){
            if(cnt == 0){
                dominant = i;
            }
            if(i == dominant){
                cnt++;
            }else{
                cnt--;
            }
        }
        
        // we can use frequency hashmap to determin dominant but it takes extra
        // space..
        
        int dominantFreq = 0;
        
        for(int i : arr){
            if(i == dominant){
                dominantFreq++;
            }
        }
        
        int n = arr.size();
        
        if(2*dominantFreq <= n){
            return -1;
        }
        
        int cnt1 = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr.get(i) == dominant){
                cnt1++;
                int cnt2 = dominantFreq-cnt1;
                if(2*cnt1 > (i+1) && 2*cnt2 > (n-(i+1))){  // n-1-(i+1)+1
                    return i;
                }
            }
        }
        
        return -1;
    }
}
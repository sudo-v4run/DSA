class Solution {
    public long countCompleteDayPairs(int[] arr) {
        
        int n = arr.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        long cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int cur = arr[i];
            
            int req = 24-(cur%24);
            
            if(req == 24){
                req = 0;
            }
            
            if(hm.containsKey(req)){
                cnt += hm.get(req);
            }
            
            hm.put(cur%24,hm.getOrDefault(cur%24,0)+1);
        }
        
        return cnt;
    }
}
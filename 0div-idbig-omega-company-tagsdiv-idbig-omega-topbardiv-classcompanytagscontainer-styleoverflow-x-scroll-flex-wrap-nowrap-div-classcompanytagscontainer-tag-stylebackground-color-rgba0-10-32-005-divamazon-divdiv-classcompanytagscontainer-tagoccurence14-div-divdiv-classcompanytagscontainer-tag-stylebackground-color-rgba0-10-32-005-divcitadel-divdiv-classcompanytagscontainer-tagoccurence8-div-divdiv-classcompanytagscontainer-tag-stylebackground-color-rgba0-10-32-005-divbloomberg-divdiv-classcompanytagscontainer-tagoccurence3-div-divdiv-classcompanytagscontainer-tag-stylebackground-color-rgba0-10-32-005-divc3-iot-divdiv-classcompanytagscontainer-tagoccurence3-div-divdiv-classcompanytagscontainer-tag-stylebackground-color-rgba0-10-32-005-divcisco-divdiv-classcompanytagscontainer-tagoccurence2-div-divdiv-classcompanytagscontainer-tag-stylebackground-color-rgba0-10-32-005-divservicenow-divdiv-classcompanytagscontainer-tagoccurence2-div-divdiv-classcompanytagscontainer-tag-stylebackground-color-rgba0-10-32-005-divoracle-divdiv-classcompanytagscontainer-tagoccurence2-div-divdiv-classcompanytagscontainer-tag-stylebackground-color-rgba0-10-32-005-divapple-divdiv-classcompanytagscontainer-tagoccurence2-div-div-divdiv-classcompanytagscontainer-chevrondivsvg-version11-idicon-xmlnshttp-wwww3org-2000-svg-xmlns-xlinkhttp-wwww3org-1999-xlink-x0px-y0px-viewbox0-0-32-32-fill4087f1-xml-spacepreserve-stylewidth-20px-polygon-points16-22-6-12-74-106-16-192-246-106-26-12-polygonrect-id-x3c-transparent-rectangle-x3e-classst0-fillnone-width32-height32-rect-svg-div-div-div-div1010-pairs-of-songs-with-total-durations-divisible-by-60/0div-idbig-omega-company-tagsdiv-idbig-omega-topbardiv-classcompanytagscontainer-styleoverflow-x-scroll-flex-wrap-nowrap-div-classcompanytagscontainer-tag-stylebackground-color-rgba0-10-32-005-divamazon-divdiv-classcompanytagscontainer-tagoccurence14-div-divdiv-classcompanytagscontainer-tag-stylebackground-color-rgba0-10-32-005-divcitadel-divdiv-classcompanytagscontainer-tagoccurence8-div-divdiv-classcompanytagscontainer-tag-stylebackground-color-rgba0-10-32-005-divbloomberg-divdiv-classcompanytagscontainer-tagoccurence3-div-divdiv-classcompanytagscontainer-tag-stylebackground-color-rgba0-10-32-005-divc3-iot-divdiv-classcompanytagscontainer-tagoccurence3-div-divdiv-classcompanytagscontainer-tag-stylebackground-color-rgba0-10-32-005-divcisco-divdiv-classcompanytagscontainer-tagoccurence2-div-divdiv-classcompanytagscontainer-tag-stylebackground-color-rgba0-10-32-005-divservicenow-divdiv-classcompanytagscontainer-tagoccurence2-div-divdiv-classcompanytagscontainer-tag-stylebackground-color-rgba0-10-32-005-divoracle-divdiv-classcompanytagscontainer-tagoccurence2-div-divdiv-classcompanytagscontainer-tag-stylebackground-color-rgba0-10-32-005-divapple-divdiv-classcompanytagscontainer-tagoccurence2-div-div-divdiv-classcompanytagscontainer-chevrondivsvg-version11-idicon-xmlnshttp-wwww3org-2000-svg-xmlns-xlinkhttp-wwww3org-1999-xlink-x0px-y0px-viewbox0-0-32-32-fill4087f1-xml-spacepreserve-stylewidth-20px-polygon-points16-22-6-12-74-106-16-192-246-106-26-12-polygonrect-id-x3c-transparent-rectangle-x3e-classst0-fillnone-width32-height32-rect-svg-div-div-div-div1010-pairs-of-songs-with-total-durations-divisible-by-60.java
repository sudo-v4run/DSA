class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int n = time.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            int rem = time[i]%60;
            
            if(hm.containsKey(60-rem)){
                cnt += hm.get(60-rem);
            }
            
            if(rem == 0){
                hm.put(60,hm.getOrDefault(60,0)+1);
            }else{
                hm.put(rem,hm.getOrDefault(rem,0)+1);
            }
        }
        
        return cnt;
    }
}
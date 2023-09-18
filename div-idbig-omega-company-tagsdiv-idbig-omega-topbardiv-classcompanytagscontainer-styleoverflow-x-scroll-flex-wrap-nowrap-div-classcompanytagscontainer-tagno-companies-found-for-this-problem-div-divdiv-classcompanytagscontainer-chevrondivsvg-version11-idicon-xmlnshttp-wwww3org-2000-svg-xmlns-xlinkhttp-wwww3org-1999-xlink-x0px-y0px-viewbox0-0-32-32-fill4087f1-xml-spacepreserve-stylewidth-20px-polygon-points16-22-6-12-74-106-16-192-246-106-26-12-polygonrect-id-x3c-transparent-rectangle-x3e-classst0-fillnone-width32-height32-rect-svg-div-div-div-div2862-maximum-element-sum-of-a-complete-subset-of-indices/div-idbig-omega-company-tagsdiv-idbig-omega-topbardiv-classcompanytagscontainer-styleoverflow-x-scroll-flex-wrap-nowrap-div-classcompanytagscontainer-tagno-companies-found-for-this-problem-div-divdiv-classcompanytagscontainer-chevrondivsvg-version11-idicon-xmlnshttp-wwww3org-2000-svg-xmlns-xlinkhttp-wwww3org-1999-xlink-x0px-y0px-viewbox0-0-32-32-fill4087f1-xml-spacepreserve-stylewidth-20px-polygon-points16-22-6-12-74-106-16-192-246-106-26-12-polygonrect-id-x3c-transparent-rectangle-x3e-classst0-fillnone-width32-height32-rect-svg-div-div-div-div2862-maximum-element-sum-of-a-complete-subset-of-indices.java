class Solution {
    public long maximumSum(List<Integer> arr) {
        
        int n = arr.size();
        
        HashMap<Integer,Long> hm = new HashMap<>();
        
        long ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            int cur = i+1;
            for(int j = 2 ; j*j <= cur ; j++){
                while(cur % (j*j) == 0){
                    cur = cur/(j*j);
                }
            }
            hm.put(cur,hm.getOrDefault(cur,0l)+arr.get(i));
            ans = Math.max(ans,hm.get(cur));
        }
        
        return ans;
    }
}
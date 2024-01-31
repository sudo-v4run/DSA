class Solution {
    public int maximumLength(int[] arr) {
        
        int n = arr.length;
        
        HashMap<Double,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            double cur = (double)arr[i];
            hm.put(cur,hm.getOrDefault(cur,0)+1);
        }
        
        Arrays.sort(arr);
        int ans = 1;
        
        HashSet<Double> vis = new HashSet<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            
            if(arr[i] == 1){
                // We handle 1 separately coz sqrt of 1 is always 1 and 
                // we will go into infinite loop...
                continue;
            }
            
            double cur = (double)arr[i];
            
            if(vis.contains(cur)){
                continue;
            }
            
            double sqrt = Math.sqrt(cur);
            
            if(!hm.containsKey(sqrt)){
                continue;
            }
            
            int cnt = 1;
            
            while(hm.containsKey(sqrt) && hm.get(sqrt) >= 2){
                
                vis.add(sqrt);
                cnt += 2;
                
                sqrt = Math.sqrt(sqrt);
            }
            ans = Math.max(ans,cnt);
        }
        
        if(hm.containsKey(1d)){ // 1d -> converts 1 to (double)1
            int oneCnt = hm.get(1d);
            if(oneCnt % 2 != 0){
                ans = Math.max(ans,oneCnt);
            }else{
                ans = Math.max(ans,oneCnt-1);
            }
        }
        
        return ans;
    }
}
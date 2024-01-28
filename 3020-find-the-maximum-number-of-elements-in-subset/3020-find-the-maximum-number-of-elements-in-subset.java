class Solution {
    public int maximumLength(int[] arr) {
        
        int n = arr.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        Arrays.sort(arr);
        int ans = 1;
        
        HashSet<Integer> vis = new HashSet<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            
            int cur = arr[i];
            
            if(cur == 1){   
                // We handle 1 separately coz sqrt of 1 is always 1 and 
                // we will go into infinite loop...
                continue;
            }
            
            if(vis.contains(cur)){
                continue;
            }
            
            int sqrt = (int)Math.sqrt(cur);
            
            if(!hm.containsKey(sqrt)){
                continue;
            }
            
            int cnt = 1;
            
            while(hm.containsKey(sqrt) && hm.get(sqrt) >= 2 && sqrt != 1){
                  // Why sqrt != 1 again? -> Although we are handling 1 
                  // separetly...and we are skipping cur = 1 at the top...
                  // sqrt(2) gives 1 and again we will get stuck in the loop...
                
                vis.add(sqrt);
                cnt += 2;
                
                sqrt = (int)Math.sqrt(sqrt);
            }
            ans = Math.max(ans,cnt);
        }
        
        if(hm.containsKey(1)){
            int oneCnt = hm.get(1);
            if(oneCnt % 2 != 0){
                ans = Math.max(ans,oneCnt);
            }else{
                ans = Math.max(ans,oneCnt-1);
            }
        }
        
        return ans;
    }
}
class Solution {
    public long numberOfPairs(int[] arr1, int[] arr2, int k) {
        
        int n = arr1.length;
        int m = arr2.length;
        
        for(int i = 0 ; i < m ; i++){
            arr2[i] = arr2[i]*k;
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int x : arr2){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        long ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int cur = arr1[i];
            // iterate through all the factors for current ele...
            for(int j = 1 ; j <= Math.sqrt(cur) ; j++){
                if(cur%j == 0){     // factor
                    ans += hm.getOrDefault(j,0);
                    if(cur/j != j){
                        ans += hm.getOrDefault(cur/j,0);
                    }
                    
                }
            }
            
        }
        
        return ans;
    }
}
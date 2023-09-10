class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int prefix = 0;
        long ans = 0;
        
        hm.put(0,1);
        
        for(int ele : nums){
            
            if(ele % mod == k){
                prefix++;
            }
            
            prefix %= mod;
            
            int prev = (prefix - k + mod) % mod;
                // (prefix - prev) % m == k => prev = (prefix - k) % mod
            
            ans += hm.getOrDefault(prev,0);
            
            hm.put(prefix,hm.getOrDefault(prefix,0)+1);
        }
        
        return ans;
    }
}
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap();
        hm.put(0,1);
        
        int ans = 0;
        int sum = 0;
        
        for(int ele : nums){
            sum += ele;
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            
            if(hm.containsKey(rem)){
                ans += hm.get(rem);
                hm.put(rem,hm.get(rem)+1);
            }else{
                hm.put(rem,1);
            }
        }
        
        return ans;
    }
}
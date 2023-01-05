class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm = new HashMap();
        
        for(int k : nums3){
            for(int l : nums4){
                hm.put(k+l,hm.getOrDefault(k+l,0)+1);
            }
        }
        
        int cnt = 0;
        
        for(int i : nums1){
            for(int j : nums2){
                cnt += hm.getOrDefault(-(i+j),0);
            }
        }
        
        return cnt;
    }
}
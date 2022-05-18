class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int k:nums){
            if(hs.contains(k))
                return true;
            else
                hs.add(k);
        }
        
        return false;
    }
}
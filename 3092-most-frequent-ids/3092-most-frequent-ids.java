class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
    long[] ans = new long[nums.length];
    HashMap<Integer, Long> idToFreqMap = new HashMap<>();
    TreeMap<Long, Integer> freqToIdCountMap = new TreeMap<>();
    for(int i = 0; i < nums.length; ++i){
        if(idToFreqMap.getOrDefault(nums[i], 0L) != 0){
            freqToIdCountMap.put(idToFreqMap.get(nums[i]), freqToIdCountMap.get(idToFreqMap.get(nums[i])) - 1);
            if(freqToIdCountMap.get(idToFreqMap.get(nums[i]) ) == 0) freqToIdCountMap.remove(idToFreqMap.get(nums[i]));   
        }
        idToFreqMap.put(nums[i], idToFreqMap.getOrDefault(nums[i], 0L) + freq[i]);
        freqToIdCountMap.put(idToFreqMap.get(nums[i]), freqToIdCountMap.getOrDefault(idToFreqMap.get(nums[i]), 0) + 1);
        ans[i] = freqToIdCountMap.lastKey();
    }
    return ans;
}
}
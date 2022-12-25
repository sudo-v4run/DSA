class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        List<Map.Entry<Integer, Integer> > list
            = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
        
        Collections.sort(list,(i1,i2) -> i2.getValue().compareTo(i1.getValue()));
        
        int ans[] = new int[k];
        int j = 0;
        
        for (Map.Entry<Integer, Integer> aa : list) {
            if(k--==0){
                break;
            }
            
            ans[j++] = aa.getKey();
        }
        
        return ans;
    }
}
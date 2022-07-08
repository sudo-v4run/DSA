class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i : nums1){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(hm.containsKey(i) && hm.get(i)>0){
                res.add(i);
                hm.put(i,hm.get(i)-1);
                
            }
        }
        int arr[] = new int[res.size()];
        
        int l = 0 ;
        
        for(int k : res){
            arr[l++] = k;
        }
        
        return arr;
    }
}
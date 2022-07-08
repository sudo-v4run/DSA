class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int  i : nums1){
            hs.add(i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : nums2){
            if(hs.contains(i)){
                res.add(i);
                hs.remove(i);
            }
        }
        int arr[] = new int[res.size()];
            
        int l = 0;
        
        for(int k : res){
            arr[l++] = k;
        }
        
        return arr;
    }
}
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
     
        int res[] = new int[2];
        int index = 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int x : nums){
            if(hs.contains(x)){
                res[index++] = x;
            }
            hs.add(x);
        }
        
        return res;
    }
}
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        
        int xor = 0;
        
        for(int ele : derived){
            xor ^= ele;
        }
        
        return xor == 0;
    }
}
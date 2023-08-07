class Solution {
    public int singleNonDuplicate(int[] arr) {
        
        int xor = 0;
        
        for(int ele : arr){
            xor = xor ^ ele;
        }
        
        return xor;
    }
}
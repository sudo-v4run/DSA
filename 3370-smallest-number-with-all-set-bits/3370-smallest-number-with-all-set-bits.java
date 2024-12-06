class Solution {
    public int smallestNumber(int n) {
        
        int x = 1;
        
        while((x-1) < n){
            x = 2*x;
        }
        
        return x-1;
    }
}
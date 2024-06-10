class Solution {
    public int numberOfChild(int n, int k) {
        
        int temp = k/(n-1);
        
        if(temp%2 == 0){
            int rem = k%(n-1);
            return rem;
        }else{
            int rem = k%(n-1);
            return n-1-rem;
        }
    }
}
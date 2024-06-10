class Solution {
    public int numberOfChild(int n, int k) {
        
        n--;
        
        int temp = k/n;
        
        if(temp%2 == 0){
            int rem = k%n;
            return rem;
        }else{
            int rem = k%n;
            return n-rem;
        }
    }
}
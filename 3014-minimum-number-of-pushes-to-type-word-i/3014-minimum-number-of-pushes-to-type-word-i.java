class Solution {
    static int i;
    public int minimumPushes(String word) {
        
        int n = word.length();
        
        i = 0;
        
        return f(n);
    }
    public int f(int n){
        
        if(n <= 8){
            return (++i)*n;
        }
        
        i++;
        
        return i*8 + f(n-8);
    }
}
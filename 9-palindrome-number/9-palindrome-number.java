class Solution {
    public boolean isPalindrome(int x) {
        
        int rev = 0;
        int t = x;
        
        if(x<0)
            return false;
        
        while(x!=0){
            int l = x%10;
            rev = rev*10+l;
            x = x/10;
        }
        
        return rev==t;
        
    }
}
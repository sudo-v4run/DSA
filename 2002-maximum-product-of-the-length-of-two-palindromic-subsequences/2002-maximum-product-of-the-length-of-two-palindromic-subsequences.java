class Solution {
    int ans;
    public int maxProduct(String s) {
        
        ans = 0;
        
        f(0,"","",s);
        
        return ans;
    }
    public void f(int index, String s1, String s2, String s){
        
        int n = s.length();
        
        if(index == n){
            if(isPali(s1) && isPali(s2)){
                ans = Math.max(ans,s1.length()*s2.length());
            }
            return;
        }
        
        f(index+1,s1+s.charAt(index),s2,s);
        
        f(index+1,s1,s2+s.charAt(index),s);
        
        f(index+1,s1,s2,s);
        
    }
    public boolean isPali(String s){
        
        int l = 0;
        int h = s.length()-1;
        
        while(l <= h){
            if(s.charAt(l) != s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        
        return true;
    }
}
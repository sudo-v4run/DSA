class Solution {
    public int countKeyChanges(String s) {
        
        int n = s.length();
        
        s = s.toLowerCase();
        
        int cnt = 0;
        
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) != s.charAt(i-1)){
                cnt++;
            }
        }
        
        return cnt;
    }
}
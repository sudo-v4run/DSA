class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        
        int res = 0;
        
        for(int i = 0 ; i < word.length() ; i++){
            
            char ch = word.charAt(i);
            res += ((i/8) +1);
        }
        
        return res;
    }
}
class Solution {
    public int titleToNumber(String columnTitle) {
        
        int res = 0;
        
        for( char ch : columnTitle.toCharArray() ){
            int toInt = ch - 'A' + 1;
            res = res*26 + toInt;
        }
        
        return res;
    }
}
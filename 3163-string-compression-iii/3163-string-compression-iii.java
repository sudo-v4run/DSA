class Solution {
    public String compressedString(String word) {
        
        int n = word.length();
        String comp = "";
        
        int i = 0;
        while(i < n){
            
            int cnt = 0;
            char c = word.charAt(i);
            while(i < n && word.charAt(i) == c && cnt < 9){
                i++;
                cnt++;
            }
            
            comp = comp+""+cnt+""+c;
        }
        
        return comp;
    }
}
class Solution {
    public int maximumLength(String s) {
        
        int n = s.length();
        
        int cntArr[][] = new int[n+1][26];
        
        int i = 0;
        int j = 0;
        while(j < n){
            
            while(j < n && s.charAt(j) == s.charAt(i)){
                j++;
            }
            
            int len = j-i;
            int cnt = 1;
            for(int k = len ; k >= 1 ; k--){
                cntArr[k][s.charAt(i)-'a'] += cnt;
                cnt++;
            }
            
            i = j;
        }
        
        for(int len = n ; len >= 1 ; len--){
            for(int ch = 0 ; ch < 26 ; ch++){
                if(cntArr[len][ch] >= 3){
                    return len;
                }
            }
        }
        
        return -1;
    }
}
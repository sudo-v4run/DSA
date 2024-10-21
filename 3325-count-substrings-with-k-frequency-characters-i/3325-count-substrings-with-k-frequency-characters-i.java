class Solution {
    public int numberOfSubstrings(String s, int k) {
        
        int n = s.length();
        
        int cnt = 0;
        
        int freq[][] = new int[n][26];
        for(int i = 0 ; i < n ; i++){
            if(i > 0){
                freq[i] = (freq[i-1]).clone();
            }
            freq[i][s.charAt(i)-'a']++;
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                
                for(int c = 0 ; c < 26 ; c++){
                    if(i > 0){
                        if(freq[j][c]-freq[i-1][c] >= k){
                            cnt++;
                            break;
                        }
                    }else{
                        if(freq[j][c] >= k){
                            cnt++;
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return cnt;
    }
}
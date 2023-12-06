class Solution {
    public int countCompleteSubstrings(String word, int k) {
        
        int cnt = 0;
        int n = word.length();
        
        int freq[][] = new int[n][26];
        
        for(int i = 0 ; i < n ; i++){
            if(i-1 >= 0)
                freq[i] = freq[i-1].clone();
            
            char cur = word.charAt(i);
            
            freq[i][cur-'a']++;
        }
        
        int leftBoundary = -1;
        for(int i = 0 ; i < n ; i++){
            if(i-1 >= 0 && Math.abs(word.charAt(i) - word.charAt(i-1)) > 2){
               
                leftBoundary = i-1;
            }
            
            int r = i;
            for(int j = 1 ; j <= 26 ; j++){
                int len = j*k;
                int l = r-len;
                
                if(l < leftBoundary){
                    break;
                }
                
                int lFreq[];
                if(l == -1){
                    lFreq = new int[26];
                }else{
                    lFreq = freq[l];
                }
                int rFreq[] = freq[r];
                boolean flag = true;
                for(int index = 0 ; index < 26 ; index++){
                    int cur = rFreq[index] - lFreq[index];
                    if(cur != 0 && cur != k){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
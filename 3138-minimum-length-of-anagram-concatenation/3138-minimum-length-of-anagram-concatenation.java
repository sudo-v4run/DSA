class Solution {
    public int minAnagramLength(String s) {
        
        int n = s.length();
        
        int prefixFreq[][] = new int[n][26];
        for(int i = 0 ; i < n ; i++){
            int ch = s.charAt(i)-'a';
            if(i >= 1){
                prefixFreq[i] = prefixFreq[i-1].clone();
                prefixFreq[i][ch]++;
            }else{
                prefixFreq[i][ch]++;
            }
        }
        
        int lo = 1;
        int hi = n+1;
        
        for(int tLen = 1 ; tLen <= n ; tLen++){
            if(isPossible(tLen,s,prefixFreq)){
               
                return tLen;
            }
        }
        
        return n;
    }
    public boolean isPossible(int tLen, String s, int prefixFreq[][]){
        
        int n = s.length();
        
        if(n%tLen != 0){
            return false;
        }
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int i = 0;
        
        for( ; i < tLen ; i++){
            char ch = s.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        while(i+tLen-1 < n){
            int j = i+tLen-1;
            
            int rFreq[] = prefixFreq[j];
            int lFreq[] = prefixFreq[i-1];
            
            for(Character key : hm.keySet()){
                int curF = hm.get(key);
                int temp = rFreq[key-'a'] - lFreq[key-'a'];
                
                if(curF != temp){
                    return false;
                }
            }
            
            i = i+tLen;
        }
        
        return true;
    }
}
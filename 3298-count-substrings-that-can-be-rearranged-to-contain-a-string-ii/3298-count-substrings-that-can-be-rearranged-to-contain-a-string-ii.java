class Solution {
    public long validSubstringCount(String word1, String word2) {
        
        int n = word1.length();
        
        HashMap<Character,Integer> w2Map = new HashMap<>();
        HashMap<Character,Integer> w1Map = new HashMap<>();
        
        for(char ch : word2.toCharArray()){
            w2Map.put(ch,w2Map.getOrDefault(ch,0)+1);
        }
        
        long ans = 0;
        
        int cnt = 0;
        
        int i = 0;
        int j = 0;
        
        while(j < n){
            
            char ch = word1.charAt(j);
            
            w1Map.put(ch,w1Map.getOrDefault(ch,0)+1);
            if(w2Map.containsKey(ch) && w1Map.get(ch).equals(w2Map.get(ch))){
                cnt++;
            }
            
            while(cnt == w2Map.size()){
                ans += n-j;
                
                char ithCh = word1.charAt(i);
                w1Map.put(ithCh,w1Map.get(ithCh)-1);
                if(w2Map.containsKey(ithCh) && w1Map.get(ithCh) < w2Map.get(ithCh)){
                    cnt--;
                }
                if(w1Map.get(ithCh) == 0){
                    w1Map.remove(ithCh);
                }

                i++;
            }
            
            j++;
        }
        
        return ans;
    }
}
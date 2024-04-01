class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        int p = 31;
        int mod1 = (int)1e9+9;
        int mod2 = (int)1e9+7;
        
        long p_pow1[] = new long[(int)1e4];
        p_pow1[0] = 1l;
        for(int i = 1 ; i < p_pow1.length ; i++){
            p_pow1[i] = (p_pow1[i-1]*p)%mod1;
        }
        long p_pow2[] = new long[(int)1e4];
        p_pow2[0] = 1l;
        for(int i = 1 ; i < p_pow2.length ; i++){
            p_pow2[i] = (p_pow2[i-1]*p)%mod2;
        }
        
        int n1 = wordsContainer.length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int index = 0 ; index < n1 ; index++){
            
            long curHash1 = 0;
            long curHash2 = 0;
            String curStr = wordsContainer[index];
            int len = curStr.length();
            
            for(int i = len-1 ; i >= 0 ; i--){
                curHash1 = (curHash1+
                           ((curStr.charAt(i)-'a'+1)*p_pow1[len-1-i])%mod1)%mod1;
                
                curHash2 = (curHash2+
                           ((curStr.charAt(i)-'a'+1)*p_pow2[len-1-i])%mod2)%mod2;
                
                String hash = curHash1+","+curHash2;
                
                if(!hm.containsKey(hash)){
                    hm.put(hash,index);
                }else{
                    if(wordsContainer[hm.get(hash)].length() > curStr.length()){
                        hm.put(hash,index);
                    }
                }
            }
        }
        
        
        
        int minLen = Integer.MAX_VALUE;
        int minInd = 0;
        for(int i = 0 ; i < n1 ; i++){
            String s = wordsContainer[i];
            if(s.length() < minLen){
                minLen = s.length();
                minInd = i;
            }
        }
        
        int n2 = wordsQuery.length;
        int ans[] = new int[n2];
        
        for(int index = 0 ; index < n2 ; index++){
            
            long curHash1 = 0;
            long curHash2 = 0;
            String curStr = wordsQuery[index];
            int len = curStr.length();
            
            ans[index] = minInd;
            
            for(int i = len-1 ; i >= 0 ; i--){
                curHash1 = (curHash1+
                           ((curStr.charAt(i)-'a'+1)*p_pow1[len-1-i])%mod1)%mod1;
                
                curHash2 = (curHash2+
                           ((curStr.charAt(i)-'a'+1)*p_pow2[len-1-i])%mod2)%mod2;
                
                String hash = curHash1+","+curHash2;
                
                if(hm.containsKey(hash)){
                    ans[index] = hm.get(hash);
                }
            }
        }
        
        return ans;
    }
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        int p = 31;
        int mod = (int)1e9+9;
        int mod2 = (int)1e9+7;
        
        long p_pow[] = new long[(int)1e4];
        p_pow[0] = 1l;
        for(int i = 1 ; i < p_pow.length ; i++){
            p_pow[i] = (p_pow[i-1]*p)%mod;
        }
        long p_pow2[] = new long[(int)1e4];
        p_pow2[0] = 1l;
        for(int i = 1 ; i < p_pow2.length ; i++){
            p_pow2[i] = (p_pow2[i-1]*p)%mod2;
        }
        
        int n1 = wordsContainer.length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int index = 0 ; index < n1 ; index++){
            
            long curHash = 0;
            long curHash2 = 0;
            String curStr = wordsContainer[index];
            int len = curStr.length();
            
            for(int i = len-1 ; i >= 0 ; i--){
                curHash = (curHash+
                           ((curStr.charAt(i)-'a'+1)*p_pow[len-1-i])%mod)%mod;
                
                curHash2 = (curHash2+
                           ((curStr.charAt(i)-'a'+1)*p_pow2[len-1-i])%mod2)%mod2;
                
                String hash = curHash+","+curHash2;
                
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
            
            long curHash = 0;
            long curHash2 = 0;
            String curStr = wordsQuery[index];
            int len = curStr.length();
            
            boolean noMatch = true;
            
            ans[index] = minInd;
            
            for(int i = len-1 ; i >= 0 ; i--){
                curHash = (curHash+
                           ((curStr.charAt(i)-'a'+1)*p_pow[len-1-i])%mod)%mod;
                
                curHash2 = (curHash2+
                           ((curStr.charAt(i)-'a'+1)*p_pow2[len-1-i])%mod2)%mod2;
                
                String hash = curHash+","+curHash2;
                
                if(hm.containsKey(hash)){
                    ans[index] = hm.get(hash);
                }
            }
        }
        
        return ans;
    }
}
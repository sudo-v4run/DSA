class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        
        int P = 37;
        int mod = (int)1e9+5;
        
        int maxSLen = (int)1e5+5;
        
        long primePower[] = new long[maxSLen];
        primePower[0] = 1;
        for(int i = 1 ; i < maxSLen ; i++){
            primePower[i] = (primePower[i-1]*P)%mod;
        }
        
        long ans = 0;
        
        HashMap<Long,Integer> hm = new HashMap<>();
        
        for(String word : words){
            
            int n = word.length();
            
            long preHash[] = new long[n];
            preHash[0] = word.charAt(0)-'a'+1;
            for(int i = 1 ; i < n ; i++){
                preHash[i] = (preHash[i-1]+
                              ((word.charAt(i)-'a'+1)*primePower[i])%mod)%mod;
            }
            
            for(int l = 0 ; l < n ; l++){
                
                long prefixHash = preHash[l];
                
                int suffixInd = n-(l+1);
                long suffixHash = preHash[n-1];
                if(suffixInd-1 >= 0){
                    suffixHash = (preHash[n-1]-preHash[suffixInd-1]+mod)%mod;
                }
                
                if((prefixHash*primePower[suffixInd])%mod == suffixHash && 
                   
                   hm.containsKey(prefixHash)){
                    
                    ans += hm.get(prefixHash);
                }
            }
         
            
            hm.put(preHash[n-1],hm.getOrDefault(preHash[n-1],0)+1);
        }
        
        return ans;
    }
}
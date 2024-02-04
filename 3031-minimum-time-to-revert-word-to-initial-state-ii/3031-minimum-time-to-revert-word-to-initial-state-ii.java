class Solution {
    static int P = 31;
    static int mod = (int)1e9+9;
    public int minimumTimeToInitialState(String word, int k) {
        
        int n = word.length();
        
        long pow[] = new long[n];
        pow[0] = 1;
        for(int i = 1 ; i < n ; i++){
            pow[i] = (pow[i-1]*P)%mod;
        }
        
        long preHash[] = new long[n];
        preHash[0] = word.charAt(0)-'a'+1;
        for(int i = 1 ; i < n ; i++){
            preHash[i] = (preHash[i-1]+((word.charAt(i)-'a'+1)*pow[i])%mod)%mod;
        }
        
        int ans = (int)Math.ceil((double)n/k);
        
        for(int i = k ; i < n ; i=i+k){
            
            long prefixHash = preHash[n-i-1];
            long suffixHash = (preHash[n-1]-preHash[i-1]+mod)%mod;
            
            if((prefixHash*pow[i])%mod == suffixHash){
                ans = Math.min(ans,i/k);
            }
        }
        
        return ans;
    }
}
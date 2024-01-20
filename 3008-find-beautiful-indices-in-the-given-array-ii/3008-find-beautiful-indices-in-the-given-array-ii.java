class Solution {
    static int mod = (int)1e9+9;
    static int P = 31;
    long preHash[];
    long pow[];
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        int n = s.length();
        List<Integer> res = new ArrayList<Integer>();
        
        if(a.length() > n || b.length() > n){
            return res;
        }

        pow = new long[n];
        pow[0] = 1;
        for(int i = 1 ; i < n ; i++){
            pow[i] = (pow[i-1]*P)%mod;
        }
        
        long aHash = 0;
        for(int i = 0 ; i < a.length() ; i++){
            char ch = a.charAt(i);
            
            aHash = (aHash+((ch-'a'+1)*(pow[i]%mod)))%mod;
        }
        
        long bHash = 0;
        for(int i = 0 ; i < b.length() ; i++){
            char ch = b.charAt(i);
            
            bHash = (bHash+((ch-'a'+1)*(pow[i]%mod)))%mod;
        }
        
        preHash = new long[n];
        preHash[0] = (s.charAt(0)-'a'+1);
        for(int i = 1 ; i < n ; i++){
            preHash[i] = (preHash[i-1] +
                          ((s.charAt(i)-'a'+1)*pow[i]%mod))%mod;
        }
        
        
        
        ArrayList<Integer> aInds = strMatch(s,aHash,a.length());
        ArrayList<Integer> bInds = strMatch(s,bHash,b.length());
        
        
        
        for(int ind : aInds){
            int tnear1 = upperBound(bInds,ind);
            
            if(tnear1 < bInds.size()){
                if(Math.abs(ind-bInds.get(tnear1)) <= k){
                    res.add(ind);
                    continue;
                }
            }
            
            int tnear2 = tnear1-1;
            
            if(tnear2 >= 0){
                if(Math.abs(ind-bInds.get(tnear2)) <= k){
                    res.add(ind);
                    continue;
                }
            }
        }
        
        return res;
    }
    public ArrayList<Integer> strMatch(String s, long patternHash, int patternLen){
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i <= s.length()-patternLen ; i++){
            
            int j = i+patternLen-1;
            
            long curHash = preHash[j];
            if(i > 0){
                curHash = (preHash[j]-preHash[i-1]+mod)%mod;
            }
            
            if(curHash == patternHash*pow[i]%mod){
                ans.add(i);
            }
        }
        
        return ans;
    }
    public int upperBound(ArrayList<Integer> arr, int target){
        
        int n = arr.size();
        
        int lo = 0;
        int hi = n-1;
        
        int ans = n;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(arr.get(mid) == target){
                return mid;
            }
            
            if(target < arr.get(mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
}
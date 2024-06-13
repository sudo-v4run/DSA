class Solution {
    public int valueAfterKSeconds(int n, int k) {
        
        int mod = (int)1e9+7;
        
        int prev[] = new int[n];
        Arrays.fill(prev,1);
        
        int cur[] = prev.clone();
        
        for(int i = 1 ; i <= k ; i++){
            
            for(int j = 1 ; j < n ; j++){
                cur[j] = (cur[j-1]+prev[j])%mod;
            }
            
            prev = cur.clone();
        }
        
        return cur[n-1]%mod;
    }
}
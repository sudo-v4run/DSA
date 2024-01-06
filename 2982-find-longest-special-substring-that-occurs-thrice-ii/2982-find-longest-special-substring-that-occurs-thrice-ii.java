class Solution {
    public int maximumLength(String s) {
        
        int n = s.length();
        
        int cntArr[][] = new int[n+1][26];
        
        int i = 0;
        int j = 0;
        while(j < n){
            
            while(j < n && s.charAt(j) == s.charAt(i)){
                j++;
            }
            
            int len = j-i;
            int cnt = 1;
            for(int k = len ; k >= 1 ; k--){
                cntArr[k][s.charAt(i)-'a'] += cnt;
                cnt++;
            }
            
            i = j;
        }
        
        for(int len = n ; len >= 1 ; len--){
            for(int ch = 0 ; ch < 26 ; ch++){
                if(cntArr[len][ch] >= 3){
                    return len;
                }
            }
        }
        
        return -1;
    }
}


// class Solution {
//     int mod;
//     int P;
    
//     int prePrimeSum[];
//     int preHash[];
//     public int maximumLength(String s) {
        
//         mod = (int)1e9+7;
//         P = 31;
        
//         int n = s.length();
        
//         preHash = new int[n];
//         preHash[0] = (((s.charAt(0)-'a')+1)*(int)Math.pow(P,1)%mod)%mod;
//         for(int i = 1 ; i < n ; i++){
//             preHash[i] = (preHash[i-1] + ((s.charAt(i)-'a')+1)*(int)Math.pow(P,i+1)%mod)%mod;
//         }
        
//         prePrimeSum = new int[n];
//         prePrimeSum[0] = P;
//         for(int i = 1 ; i < n ; i++){
//             prePrimeSum[i] = (prePrimeSum[i-1] + (int)Math.pow(P,i+1)%mod)%mod;
//         }
        
//         int l = 1;
//         int h = n;
        
//         int ans = -1;
        
//         while(l <= h){
//             int mid = (l+h)/2;
            
//             if(isPossible(s,mid)){
//                 ans = mid;
//                 l = mid+1;
//             }else{
//                 h = mid-1;
//             }
//         }
        
//         return ans;
//     }
//     public boolean isPossible(String s, int len){
        
//         int n = s.length();
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         int l = 0;
//         while(l <= n-len){
            
//             int r = l+len-1;
//             int strHash = preHash[r];
//             if(l > 0){
//                 strHash = (preHash[r] - preHash[l-1] + mod)%mod;
//             }
//             strHash = (strHash / (int)Math.pow(P,l)%mod)%mod;
            
//             hm.put(strHash,hm.getOrDefault(strHash,0)+1);
            
//             l++;
//         }
        
//         HashSet<Integer> spls = new HashSet<>();
        
//         int sum = prePrimeSum[len-1];
        
//         for(int i = 1 ; i <= 26 ; i++){
//             int cur = (i*sum)%mod;
//             spls.add(cur);
//         }
        
//         for(int hash : hm.keySet()){
//             if(spls.contains(hash)){
//                 if(hm.get(hash) >= 3){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }
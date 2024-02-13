class Solution {
    public int countMatchingSubarrays(int[] arr, int[] pattern) {
        
        int n = arr.length;
        
        int P = 37;
        int mod = (int)1e9+9;
        
        StringBuilder s = new StringBuilder();
        
        // 1 -> a ; 0 -> b ; -1 -> c
        
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] < arr[i+1]){
                s.append('a');
            }else if(arr[i] == arr[i+1]){
                s.append('b');
            }else{
                s.append('c');
            }
        }
        
        StringBuilder ptr = new StringBuilder();
        for(int ele : pattern){
            if(ele == 1){
                ptr.append('a');
            }else if(ele == 0){
                ptr.append('b');
            }else{
                ptr.append('c');
            }
        }
        
        String str = new String(s);
        String ptrn = new String(ptr);
        
        int len = str.length();
        
        long prePrimePow[] = new long[len];
        prePrimePow[0] = 1;
        for(int i = 1 ; i < len ; i++){
            prePrimePow[i] = (prePrimePow[i-1]*P)%mod;
        }
        
        long preHash[] = new long[len];
        preHash[0] = str.charAt(0)-'a'+1;
        for(int i = 1 ; i < len ; i++){
            preHash[i] = (preHash[i-1] + ((str.charAt(i)-'a'+1)*prePrimePow[i]%mod))%mod;
        }
        
        long hash = 0;
        for(int i = 0 ; i < ptrn.length() ; i++){
            hash = (hash + (ptrn.charAt(i)-'a'+1)*prePrimePow[i]%mod)%mod;
        }
        
        int cnt = 0;
        
        int l = 0;
        int r = pattern.length-1;
        while(r < len){
            long curHash = preHash[r];
            if(l > 0){
                curHash = (preHash[r]-preHash[l-1]+mod)%mod;
            }
            
            if(curHash == hash*prePrimePow[l]%mod){
                cnt++;
            }
            
            r++;
            l++;
        }
        
        return cnt;
    }
}
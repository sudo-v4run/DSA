class Solution {
    public int countPrimes(int n) {
        
        int cnt = 0;
        boolean notPrime[] = new boolean[n];
        
        for(int i = 2 ; i < n ; i++){
            
            if(notPrime[i])
                continue;
            
            cnt++;
            
            for(int j = 2*i ; j < n ; j = j+i){
                notPrime[j] = true;
            }
        }
        
        return cnt;    
        
        
//         int cnt = 0;
//         boolean isPrime[] = new boolean[n];
        
//         Arrays.fill(isPrime,true);
        
//         for(int i = 2 ; i*i < n ; i++){
//             if(isPrime[i]){
//                 for(int j = i*i ; j < n ; j = j+i){
//                     isPrime[j] = false;
//                 }
//             }
//         }
        
//         for(int i = 2 ; i < n ; i++){
//             if(isPrime[i]){
//                 cnt++;
//             }
//         }
        
//         return cnt;
    }
}
class Solution {
    
    static List<List<Integer>> res;
    static ArrayList<Integer> ans;
    
    public List<List<Integer>> findPrimePairs(int n) {
        
        res = new ArrayList<>();
        ans = new ArrayList<>();
        
        int isPrime[] = new int[n+1];
        Arrays.fill(isPrime,1);
        
        for(int i = 2 ; i*i <= n ; i++){
            if(isPrime[i] == 1){
                for(int j = 2*i ; j <= n ; j = j+i){
                    isPrime[j] = 0;
                }
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        
        for(int i = 2 ; i <= n ; i++){
            if(isPrime[i] == 1){
                primes.add(i);
            }
        }
        
        int i = 0;
        int j = primes.size()-1;
        
        while(i <= j){
            if(primes.get(i) + primes.get(j) == n){
                res.add(new ArrayList<>(Arrays.asList(primes.get(i),primes.get(j))));
                i++;
            }else if(primes.get(i) + primes.get(j) < n){
                i++;
            }else if(primes.get(i) + primes.get(j) > n){
                j--;
            }
        }
        
        return res;
        
    

        
//         for(int i = 2 ; i <= n ; i++){
//             if(isPrime(i)){
//                 ans.add(i);
//                 f(i,n-i);
//                 ans.remove(ans.size()-1);
//             }
//         }
        
//         return res;
    }
    public static void f(int i, int sum){
        
        for(int j = i ; j <= sum ; j++ ){
            if(isPrime(j) && sum-j == 0){
                ans.add(j);
                res.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
                return;
            }
        }
    }
    public static boolean isPrime(int n){
        
        for(int i = 2 ; i <= n-1 ; i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
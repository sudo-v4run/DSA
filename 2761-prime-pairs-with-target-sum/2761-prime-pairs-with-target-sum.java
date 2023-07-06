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
        
        for(int i = 2 ; i <= n ; i++){
            int j = n-i;
            if(isPrime[i] == 1 && isPrime[j] == 1 && i <= j){
                res.add(new ArrayList<>(Arrays.asList(i,j)));
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
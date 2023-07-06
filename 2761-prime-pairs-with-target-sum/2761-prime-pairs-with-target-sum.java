class Solution {
    
    static List<List<Integer>> res;
    
    public List<List<Integer>> findPrimePairs(int n) {
        
        res = new ArrayList<>();
        
        int isPrime[] = new int[n+1];
        Arrays.fill(isPrime,1);
        
        for(int i = 2 ; i*i <= n ; i++){
            if(isPrime[i] == 1){
                for(int j = i*i ; j <= n ; j = j+i){    // j = 2*i
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
    }
}
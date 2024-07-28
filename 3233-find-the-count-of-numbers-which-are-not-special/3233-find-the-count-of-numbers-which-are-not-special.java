class Solution {
    public int nonSpecialCount(int l, int r) {
        
        int max = (int)Math.sqrt(r);
        boolean isPrime[] = f(max);
        
        int cnt = 0;
        
        for(int i = 2 ; i <= max ; i++){
            if(isPrime[i]){
                if(l <= i*i && i*i <= r){
                    cnt++;
                }
            }
        }
        
        return (r-l+1)-cnt;
    }
    public boolean[] f(int n){
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
class Solution {
    public long flowerGame(int n, int m) {
        
        long evens_n = n/2;
        long odds_n = (n+1)/2;
        
        long evens_m = m/2;
        long odds_m = (m+1)/2;
        
        return evens_n*odds_m + odds_n*evens_m;
    }
}
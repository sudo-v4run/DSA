class Solution {
    public long maxScore(int[] a, int[] b) {
        
        int n = b.length;
        
        long dp[][] = new long[n][5];
        for(long row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,0,a,b,dp);
    }
    public long f(int index, int cnt, int a[], int b[], long dp[][]){
        
        int n = b.length;
        
        if(cnt >= 4){
            return 0;
        }
        
        if(index >= n){
            return -1l*(long)1e13;
        }
        
        if(dp[index][cnt] != -1){
            return dp[index][cnt];
        }
        
        long take = a[cnt]*1l*b[index] + f(index+1,cnt+1,a,b,dp)*1l;
        long notTake = f(index+1,cnt,a,b,dp);
        
        return dp[index][cnt] = Math.max(take,notTake);
    }
}
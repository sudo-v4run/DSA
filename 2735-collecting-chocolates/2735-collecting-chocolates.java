class Solution {
    public long minCost(int[] arr, int x) {
        
        int n = arr.length;
        
        int minC[] = new int[n];
        Arrays.fill(minC,Integer.MAX_VALUE);
        
        long ans = Long.MAX_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            long cost = (long)x*i;
            
            for(int ind = 0 ; ind < n ; ind++){
                minC[ind] = Math.min(minC[ind],arr[(ind-i+n)%n]);
                cost += minC[ind];
            }
            
            ans = Math.min(ans,cost);
        }
        
        return ans;
    }
}
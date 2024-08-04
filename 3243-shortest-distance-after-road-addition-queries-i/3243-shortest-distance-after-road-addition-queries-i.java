class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n-1 ; i++){
            adj.get(i).add(i+1);
        }
        
        int res[] = new int[queries.length];
        int index = 0;
        
        for(int q[] : queries){
            int u = q[0];
            int v = q[1];
            
            adj.get(u).add(v);
            
            int dp[] = new int[n];
            Arrays.fill(dp,-1);
            
            int cnt = f(0,n,adj,dp);
            
            res[index++] = cnt;
        }
        
        return res;
    }
    public int f(int i, int n, ArrayList<ArrayList<Integer>> adj, int dp[]){
        
        if(i >= n-1){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int nei : adj.get(i)){
            int cur = 1 + f(nei,n,adj,dp);
            ans = Math.min(ans,cur);
        }
        
        return dp[i] = ans;
    }
}
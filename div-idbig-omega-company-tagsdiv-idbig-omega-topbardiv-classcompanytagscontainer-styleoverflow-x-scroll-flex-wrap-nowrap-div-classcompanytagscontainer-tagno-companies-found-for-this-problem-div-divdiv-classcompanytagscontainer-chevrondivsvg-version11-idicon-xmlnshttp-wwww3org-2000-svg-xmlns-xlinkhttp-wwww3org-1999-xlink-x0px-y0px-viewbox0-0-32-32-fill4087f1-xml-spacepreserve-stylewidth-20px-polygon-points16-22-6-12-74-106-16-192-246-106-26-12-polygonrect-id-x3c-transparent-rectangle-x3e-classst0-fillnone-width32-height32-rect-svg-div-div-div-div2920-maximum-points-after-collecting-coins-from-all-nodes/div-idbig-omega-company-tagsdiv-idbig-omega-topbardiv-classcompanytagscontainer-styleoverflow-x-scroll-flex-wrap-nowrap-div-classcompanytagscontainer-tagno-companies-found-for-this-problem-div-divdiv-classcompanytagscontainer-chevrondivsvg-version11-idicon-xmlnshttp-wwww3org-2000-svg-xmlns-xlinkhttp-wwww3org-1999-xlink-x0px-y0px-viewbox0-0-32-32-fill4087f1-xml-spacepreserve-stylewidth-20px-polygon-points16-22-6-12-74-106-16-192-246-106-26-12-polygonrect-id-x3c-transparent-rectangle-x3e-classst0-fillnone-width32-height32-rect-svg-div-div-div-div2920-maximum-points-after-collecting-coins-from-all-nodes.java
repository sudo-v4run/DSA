class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int n = coins.length;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int dp[][] = new int[n][15];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return dfs(0,0,-1,k,coins,adj,dp);
    }
    public int dfs(int v, int reduceCnt, int par, 
                   int k, int coins[], ArrayList<ArrayList<Integer>> adj, int dp[][]){
        
        if(reduceCnt > 14){
            return 0;
        }
        
        if(dp[v][reduceCnt] != -1){
            return dp[v][reduceCnt];
        }
        
        int val = coins[v];
            // This is imp...if you directly reduce the coins[v] value, then you have to 
            // backtrack for other dfs calls. So instead, store it in a variable, say val
            // and use it. This will also help in not changing the input array.
            // This is also helps in DP coz if we directly change the coins[v] value,
            // then coins[index] will have different value at different dfs calls,
            // which also changes the meaning of dp[index] 
        
        for(int i = 0 ; i < reduceCnt ; i++){
            val = val/2;
        }
        
        int firstWay = val-k;
        int secondWay = val/2;
        for(int nei : adj.get(v)){
            if(nei == par){
                continue;
            }
            firstWay += dfs(nei,reduceCnt,v,k,coins,adj,dp);
        }
        for(int nei : adj.get(v)){
            if(nei == par){
                continue;
            }
            secondWay += dfs(nei,reduceCnt+1,v,k,coins,adj,dp);
        }
        
        return dp[v][reduceCnt] = Math.max(firstWay,secondWay);
    }
}
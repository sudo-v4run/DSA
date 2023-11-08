class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        
        int n = values.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        long dp[][] = new long[n][2];
        for(long row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return f(0,0,-1,values,adj,dp);
    }
    public long f(int v, int isSkipped, int parent,
                  int vals[], ArrayList<ArrayList<Integer>> adj, long dp[][]){
        
        if(adj.get(v).size() == 1 && v != 0){
            if(isSkipped == 1){
                // there should be atleast one skipped node in every 
                // path inorder to be healthy...
                
                return vals[v];
            }
            return 0;
        }
        
        if(dp[v][isSkipped] != -1){
            return dp[v][isSkipped];
        }
        
        long skip = 0;
        for(int nei : adj.get(v)){
            if(nei == parent){
                continue;
            }
            skip += f(nei,1,v,vals,adj,dp);
        }
        
        long notSkip = vals[v];
        for(int nei : adj.get(v)){
            if(nei == parent){
                continue;
            }
            notSkip += f(nei,isSkipped,v,vals,adj,dp);
        }
        
        return dp[v][isSkipped] = Math.max(skip,notSkip);
    }
}
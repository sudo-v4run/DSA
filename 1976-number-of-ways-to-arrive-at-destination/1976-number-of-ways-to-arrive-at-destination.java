class Solution {
    
    static class Pair{
        long node,wt;
        
        Pair(long node, long wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int countPaths(int n, int[][] roads){
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int ed[] : roads){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        long dis[] = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;
        
        long ways[] = new long[n];
        ways[0] = 1;
        
        PriorityQueue<Pair> pq;
        pq = new PriorityQueue<>((a,b)->{return (int)a.wt-(int)b.wt;});
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair pop = pq.poll();
            long node = pop.node;
            long wt = pop.wt;
            
            for(Pair nei : adj.get((int)node)){
                long adjNode = nei.node;
                long adjWt = nei.wt;
                
                long adjDist = (wt+adjWt);
                
                if(adjDist < dis[(int)adjNode]){
                    dis[(int)adjNode] = adjDist;
                    pq.add(new Pair(adjNode,adjDist));
                    ways[(int)adjNode] = ways[(int)node]%1000000007;
                }else if(adjDist == dis[(int)adjNode]){
                    ways[(int)adjNode] = 
                        (ways[(int)adjNode] + ways[(int)node])%1000000007;
                }
            }
        }
        
        return (int)ways[n-1];
    }
    
    
    
    
    // DFS ..... Gives TLE....
    
//     static class Pair{
//         int node,wt;
        
//         Pair(int node, int wt){
//             this.node = node;
//             this.wt = wt;
//         }
//     }
//     static int minPathValue,n;
//     public int countPaths(int v, int[][] roads) {
        
//         n = v;
//         minPathValue = Integer.MAX_VALUE;
        
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int i = 0 ; i < v ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int ed[] : roads){
//             int U = ed[0];
//             int V = ed[1];
//             int wt = ed[2];
            
//             adj.get(U).add(new Pair(V,wt));
//             adj.get(V).add(new Pair(U,wt));
//         }
        
//         int vis[] = new int[v];
        
//         dfs(0,adj,vis,0,hm);
        
//         return hm.get(minPathValue);
//     }
//     public static void dfs(int v, ArrayList<ArrayList<Pair>> adj, int vis[], int time,
//                       HashMap<Integer,Integer> hm){
        
//         vis[v] = 1;
        
//         if(v == n-1){
//             hm.put(time,hm.getOrDefault(time,0)+1);
//             minPathValue = Math.min(minPathValue,time);
//         }
        
//         for(Pair nei : adj.get(v)){
//             int adjNode = nei.node;
//             int wt = nei.wt;
            
//             if(vis[adjNode] != 1){
//                 dfs(adjNode,adj,vis,time+wt,hm);
//             }
//         }
        
//         vis[v] = 0;
//     }
}
class Solution {
    
    // Floyd Warshall Algo..
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int matrix[][] = new int[n][n];
        
        for(int row[]: matrix){
            Arrays.fill(row,(int)1e7);
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }
        
        // Floyd Warshall Algo...
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                matrix[i][i] = 0;
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        int ans = -1;
        int min = n;
        
        for(int i = 0 ; i < n ; i++){
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=min){
                min = cnt;
                ans = i;
            }
        }
        
        return ans;
    }
    
    
    
    
    
    // Dijkstras Algo...
    
//     static class Pair{
        
//         int node,wt;
//         Pair(int node, int wt){
//             this.node = node;
//             this.wt = wt;
//         }
//     }
//     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
//         for(int i = 0 ; i < n ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int ed[] : edges){
//             int u = ed[0];
//             int v = ed[1];
//             int wt = ed[2];
            
//             adj.get(u).add(new Pair(v,wt));
//             adj.get(v).add(new Pair(u,wt));
//         }
        
//         int dis[][] = new int[n][n];
//         for(int row[] : dis){
//             Arrays.fill(row,(int)1e7);
//         }
        
//         for(int src = 0 ; src < n ; src++){
            
//             // Dijkstra's Algo...
            
//             PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
//             pq.add(new Pair(src,0));
//             dis[src][src] = 0;
            
//             while(!pq.isEmpty()){
//                 Pair pop = pq.poll();
//                 int node = pop.node;
//                 int wt = pop.wt;
                
//                 for(Pair nei : adj.get(node)){
//                     int adjNode = nei.node;
//                     int adjWt = nei.wt;
//                     int adjDist = wt+adjWt;
                    
//                     if(adjDist < dis[src][adjNode]){
//                         dis[src][adjNode] = adjDist;
//                         pq.add(new Pair(adjNode,adjDist));
//                     }
//                 }
//             }
            
//         }
        
        
//         int ans = -1;
//         int min = n;
        
//         for(int i = 0 ; i < n ; i++){
//             int cnt = 0;
//             for(int j = 0 ; j < n ; j++){
//                 if(dis[i][j] <= distanceThreshold){
//                     cnt++;
//                 }
//             }
//             if(cnt<=min){
//                 min = cnt;
//                 ans = i;
//             }
//         }
        
//         return ans;
//      }
}
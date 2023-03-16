class Solution {
    
    static class Pair{
        int node,wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    static class Tuple{
        int node;
        int wt;
        int stops;
        
        Tuple(int node, int wt, int stops){
            this.node = node;
            this.wt = wt;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
//         for(int i = 0 ; i < n ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int ed[] : flights){
//             int u = ed[0];
//             int v = ed[1];
//             int wt = ed[2];
            
//             adj.get(u).add(new Pair(v,wt));
//         }
        
//         int dist[] = new int[n];
//         Arrays.fill(dist,(int)1e7);
//         dist[src] = 0;
        
//         PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
//         pq.add(new Tuple(src,0,0));
        
//         while(!pq.isEmpty()){
//             Tuple pop = pq.poll();
//             int node = pop.node;
//             int wt = pop.wt;
//             int stops = pop.stops;
            
//             if(stops > k){
//                 continue;
//             }
            
//             for(Pair ed : adj.get(node)){
//                 int adjWt = wt + ed.wt;
                
//                 if(adjWt < dist[ed.node]){
//                     dist[ed.node] = adjWt;
//                     pq.add(new Tuple(ed.node,adjWt,stops+1));
//                 }
//             }
//         }
        
//         if(dist[dst] == (int)1e7){
//             return -1;
//         }
//         return dist[dst];
        
        
        
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : flights){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            
            adj.get(u).add(new Pair(v,wt));
        }
        
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e7);
        dist[src] = 0;
        
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(src,0,0));
        
        while(!pq.isEmpty()){
            Tuple pop = pq.poll();
            int node = pop.node;
            int wt = pop.wt;
            int stops = pop.stops;
            
            if(stops > k){
                continue;
            }
            
            for(Pair ed : adj.get(node)){
                int adjWt = wt + ed.wt;
                
                if(adjWt < dist[ed.node]){
                    dist[ed.node] = adjWt;
                    pq.add(new Tuple(ed.node,adjWt,stops+1));
                }
            }
        }
        
        if(dist[dst] == (int)1e7)
            return -1;
        
        return dist[dst];
    }
}
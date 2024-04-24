class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        
        ArrayList<Integer>[] parent = new ArrayList[n];
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
        q.add(new Pair(0,0));
        
        while(!q.isEmpty()){
            
            Pair pop = q.poll();
            int node = pop.node;
            int wt = pop.wt;
            
            for(Pair nei : adj.get(node)){
                
                int adjNode = nei.node;
                int adjWt = nei.wt;
                
                int adjDist = wt+adjWt;
                
                if(dist[adjNode] < adjDist){
                    continue;
                }
                
                if(adjDist == dist[adjNode]){
                    parent[adjNode].add(node);
                }else{
                    parent[adjNode] = new ArrayList<>();
                    parent[adjNode].add(node);
                    dist[adjNode] = adjDist;
                    q.add(new Pair(adjNode,adjDist));
                }
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        que.add(n-1);
        
        boolean ans[] = new boolean[edges.length];
        
        HashMap<String,Integer> edgeInds = new HashMap<>();
        for(int i = 0 ; i < edges.length ; i++){
            int ed[] = edges[i];
            int u = ed[0];
            int v = ed[1];
            
            edgeInds.put(u+","+v,i);
            edgeInds.put(v+","+u,i);
        }
        
        HashSet<Integer> vis = new HashSet<>();
        
        while(!que.isEmpty()){
            
            int pop = que.poll();
            
            if(parent[pop] == null){
                continue;
            }
            
            for(int nei : parent[pop]){
                
                String edg = pop+","+nei;
                ans[edgeInds.get(edg)] = true;
                
                if(!vis.contains(nei)){
                    vis.add(nei);
                    que.add(nei);
                }
            }
        }
        
        return ans;
    }
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
}
class Solution {
    public long maximizeSumOfWeights(int[][] edges, int k) {
     
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int n = (int)1e5+1;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : edges){
            
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        HashMap<String,Long> dp = new HashMap<>();
        
        return f(0,0,-1,k,adj,dp);
    }
    public long f(int node, int isParentRemoved, int par, int k, 
                  ArrayList<ArrayList<Pair>> adj, HashMap<String,Long> dp){
        
        String curState = node+","+isParentRemoved;
        
        if(dp.containsKey(curState)){
            return dp.get(curState);
        }
        
        int edges_to_remove = Math.max(0,adj.get(node).size()-k-isParentRemoved);
        
        ArrayList<Pair2> edges_sorted = new ArrayList<>();
    
        for(Pair nei : adj.get(node)){
            
            int v = nei.v;
            int w = nei.wt;
            
            if(v == par){
                continue;
            }
            
            long remove = f(v,1,node,k,adj,dp);
            long notRemove = w + f(v,0,node,k,adj,dp);
            
            edges_sorted.add(new Pair2(remove,notRemove));
        }
        
        Collections.sort(edges_sorted,(a,b)->{
            return Long.compare((a.notRemove-a.remove) , (b.notRemove-b.remove)) ;
        });
        
        long sum = 0;
        
        for(int i = 0 ; i < edges_sorted.size() ; i++){
            if(i < edges_to_remove){
                sum += edges_sorted.get(i).remove;
            }else{
                sum += Math.max(edges_sorted.get(i).remove,edges_sorted.get(i).notRemove);
            }
        }
        
        dp.put(curState,sum);
        
        return sum;
    }
    class Pair{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    class Pair2{
        long remove;
        long notRemove;
        Pair2(long remove, long notRemove){
            this.remove = remove;
            this.notRemove = notRemove;
        }
    }
}
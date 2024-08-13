class Solution {
    static int cnt;
    public int countGoodNodes(int[][] edges) {
        
        cnt = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < edges.length+1 ; i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        HashSet<Integer> vis = new HashSet<>();
        f(0,adj,vis);

        return cnt;
    }
    public int f(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis){

        int sz = 1;
        HashSet<Integer> hs = new HashSet<>();

        vis.add(node);

        for(int nei : adj.get(node)){

            if(vis.contains(nei)){
                continue;
            }
            
            int cur = f(nei,adj,vis);
            sz += cur;
            hs.add(cur);
        }

        if(adj.get(node).size() == 1){
            cnt++;
        }else if(hs.size() == 1){
            cnt++;
        }

        return sz;
    }
}
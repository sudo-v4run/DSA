class DisjointSet{
    int parent[],rank[];
    DisjointSet(int n){
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
    }
    int findParent(int u){
        if(parent[u] == u){
            return u;
        }
        
        return parent[u] = findParent(parent[u]);
    }
    void union(int a, int b){
        int parent_a = findParent(a);
        int parent_b = findParent(b);
        
        if(parent_a == parent_b){
            return;
        }
        
        int rank_parent_a = rank[parent_a];
        int rank_parent_b = rank[parent_b];
        
        if(rank_parent_a < rank_parent_b){
            parent[parent_a] = parent_b;
        }else if(rank_parent_a > rank_parent_b){
            parent[parent_b] = parent_a;
        }else{
            parent[parent_b] = parent_a;
            rank[parent_a]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet d = new DisjointSet(n);
        int extraEdges = 0;
        
        for(int ed[] : connections){
            int u = ed[0];
            int v = ed[1];
            
            if(d.findParent(u)!=d.findParent(v)){
                d.union(u,v);
            }else{
                extraEdges++;
            }
        }
        
        int nc = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(d.parent[i] == i){
                nc++;
            }
        }
        
        int ans = nc-1;
        
        if(extraEdges >= ans){
            return ans;
        }
        return -1;
    }
}
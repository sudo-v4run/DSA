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
    public int removeStones(int[][] stones) {
        
        int maxR = 0, maxC = 0;
        int n = stones.length;
        
        for(int ed[] : stones){
            maxR = Math.max(maxR,ed[0]);
            maxC = Math.max(maxC,ed[1]);
        }
        
        DisjointSet d = new DisjointSet(maxR+maxC+2);
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int ed[] : stones){
            int rowNode = ed[0];
            int colNode = maxR+1+ed[1];
            
            d.union(rowNode,colNode);
            hs.add(rowNode);
            hs.add(colNode);
        }
        
        int nc = 0;
        for(int node : hs){
            if(d.findParent(node) == node){
                nc++;
            }
        }
        
        return n - nc;
    }
}
class Solution {
    class DSU{
        
        int parent[];
        int n;
        
        DSU(int n){
            parent = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }
        
        public int findParent(int x){
            if(parent[x] == x){
                return x;
            }
            
            return parent[x] = findParent(parent[x]);
        }
        
        public void merge(int a, int b){
            
            int parA = findParent(a);
            int parB = findParent(b);
            
            if(parA == parB){
                return;
            }
            
            parent[parA] = parB;
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        int ANDvals[] = new int[n];
        Arrays.fill(ANDvals,-1);
        
        DSU d = new DSU(n);
        
        for(int edge[] : edges){
        
            int u = edge[0];
            int v = edge[1];
            
            d.merge(u,v);
        }
        
        for(int edge[] : edges){
            
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int p = d.findParent(u);
            
            if(ANDvals[p] == -1){
                ANDvals[p] = w;
            }else{
                ANDvals[p] = ANDvals[p] & w;
            }
        }
        
        int ans[] = new int[query.length];
        int index = 0;
        
        for(int q[] : query){
            
            int s = q[0];
            int t = q[1];
            
            int parS = d.findParent(s);
            int parT = d.findParent(t);
            
            if(parS != parT){
                ans[index++] = -1;
            }else{
                ans[index++] = ANDvals[parT];
            }
        }
        
        return ans;
    }
}
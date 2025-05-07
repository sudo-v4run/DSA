class Solution {
    class DSU{

        int par[];

        DSU(int n){
            par = new int[n];
            for(int i = 0 ; i < n ; i++){
                par[i] = i;
            }
        }

        int findParent(int x){

            if(par[x] == x){
                return x;
            }

            return par[x] = findParent(par[x]);
        }

        void union(int a, int b){

            int parOfa = findParent(a);
            int parOfb = findParent(b);

            if(parOfa == parOfb){
                return;
            }

            par[parOfa] = parOfb;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU dsu = new DSU(n+1);

        int cnt = 0;
        int both = 0;
        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 3){
                if(dsu.findParent(u) != dsu.findParent(v)){
                    dsu.union(u,v);
                    both++;
                }else{
                    cnt++;
                }
            }
        }

        
        int alice = 0;

        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 1){
                if(dsu.findParent(u) == dsu.findParent(v)){
                    cnt++;
                }else{
                    alice++;
                    dsu.union(u,v);
                }
            }
        }

        dsu = new DSU(n+1);

        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 3){
                if(dsu.findParent(u) != dsu.findParent(v)){
                    dsu.union(u,v);
                }
            }
        }

        int bob = 0;

        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 2){
                if(dsu.findParent(u) == dsu.findParent(v)){
                    cnt++;
                }else{
                    bob++;
                    dsu.union(u,v);
                }
            }
        }

        if(alice + both < n-1){
            return -1;
        }
        if(bob + both < n-1){
            return -1;
        }
        return cnt;
    }
}
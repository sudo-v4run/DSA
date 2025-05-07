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
                if(dsu.findParent(u) == dsu.findParent(v)){
                    cnt++;
                }else{
                    dsu.union(u,v);
                    both++;
                }
            }
        }

        int temp[] = dsu.par.clone();
        int aliceEdges = 0;

        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 1){
                if(dsu.findParent(u) == dsu.findParent(v)){
                    cnt++;
                }else{
                    aliceEdges++;
                    dsu.union(u,v);
                }
            }
        }

        dsu.par = temp;

        // for(int e[] : edges){
        //     int t = e[0];
        //     int u = e[1];
        //     int v = e[2];

        //     if(t == 3){
        //         if(dsu.findParent(u) != dsu.findParent(v)){
        //             dsu.union(u,v);
        //         }
        //     }
        // }

        int bobEdges = 0;

        for(int e[] : edges){
            int t = e[0];
            int u = e[1];
            int v = e[2];

            if(t == 2){
                if(dsu.findParent(u) == dsu.findParent(v)){
                    cnt++;
                }else{
                    bobEdges++;
                    dsu.union(u,v);
                }
            }
        }

        if(aliceEdges + both < n-1){
            return -1;
        }

        if(bobEdges + both < n-1){
            return -1;
        }

        return cnt;
    }
}
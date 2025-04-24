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

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int V, int[][] edges) {
        
        int n = edges.length;

        int newEdges[][] = new int[n][4];

        for(int i = 0 ; i < n ; i++){
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges,(a,b)->{return a[2]-b[2];});

        DSU dsu = new DSU(V);

        int mst = 0;

        for(int i = 0 ; i < n ; i++){

            int u = newEdges[i][0];
            int v = newEdges[i][1];

            if(dsu.findParent(u) != dsu.findParent(v)){

                mst += newEdges[i][2];

                dsu.union(u,v);
            }
        }

        ArrayList<Integer> critical = new ArrayList<>();
        ArrayList<Integer> pseudo = new ArrayList<>();

        for(int e[] : newEdges){

            int curEdgeInd = e[3];

            dsu = new DSU(V);

            int cur = 0;
            int mstEdgesCnt = 0;

            for(int i = 0 ; i < n ; i++){

                int u = newEdges[i][0];
                int v = newEdges[i][1];
                int ind = newEdges[i][3];

                if(curEdgeInd == ind){
                    continue;
                }

                if(dsu.findParent(u) != dsu.findParent(v)){

                    cur += newEdges[i][2];

                    dsu.union(u,v);
                    mstEdgesCnt++;
                }
            }

            if(mstEdgesCnt != V-1 || cur > mst){

                // critical edge

                critical.add(curEdgeInd);

                // a critical edge can't be psuedo..so continue..

                continue;
            }

            // check for pseudo... 

            dsu = new DSU(V);
            cur = e[2];  // check by including the current edge
            if(dsu.findParent(e[0]) != dsu.findParent(e[1])){
                dsu.union(e[0],e[1]);
            }

            for(int i = 0 ; i < n ; i++){

                int u = newEdges[i][0];
                int v = newEdges[i][1];
                int ind = newEdges[i][3];

                if(curEdgeInd == ind){
                    continue;
                }

                if(dsu.findParent(u) != dsu.findParent(v)){

                    cur += newEdges[i][2];

                    dsu.union(u,v);
                }
            }

            if(cur == mst){

                // pseudo edge

                pseudo.add(curEdgeInd);
            }
        }

        List<List<Integer>> res  = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);

        return res;
    }
    class Pair{
        int node, wt, index;
        Pair(int node, int wt, int index){
            this.node = node;
            this.wt = wt;
            this.index = index;
        }
    }
    
}
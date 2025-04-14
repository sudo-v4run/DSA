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
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        DSU d = new DSU(n);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.dist-b.dist;
        });

        for(int i = 0 ; i < n ; i++){
            int xi = points[i][0];
            int yi = points[i][1];
            for(int j = i+1 ; j < points.length ; j++){
                if(i == j){
                    continue;
                }
                int xj = points[j][0];
                int yj = points[j][1];

                int dist = Math.abs(xi-xj)+Math.abs(yi-yj);

                pq.add(new Pair(dist,i,j));
            }
        }

        int cost = 0;

        while(!pq.isEmpty()){

            Pair pop = pq.poll();
            
            int point1 = pop.point1;
            int point2 = pop.point2;

            if(d.findParent(point1) != d.findParent(point2)){

                cost += pop.dist;

                d.union(point1,point2);
            }
        }

        return cost;
    }
    class Pair{

        int dist;
        int point1;
        int point2;

        Pair(int dist, int point1, int point2){
            this.dist = dist;
            this.point1 = point1;
            this.point2 = point2;
        }
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        n++;
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int t[] : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];

            adj.get(u).add(new Pair(v,w));
        }

        int dis[] = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.wt-b.wt;});
        pq.add(new Pair(k,0));

        HashSet<Integer> vis = new HashSet<>();
        vis.add(k);

        while(!pq.isEmpty()){

            Pair pop = pq.poll();
            int v = pop.v;
            int wt = pop.wt;

            for(Pair nei : adj.get(v)){

                int adjNode = nei.v;
                int adjWt = nei.wt;

                if(vis.contains(adjNode)){
                    continue;
                }

                if(dis[adjNode] > wt+adjWt){
                    dis[adjNode] = wt+adjWt;
                    pq.add(new Pair(adjNode,dis[adjNode]));
                }
            }
        }

        int ans = -1;

        for(int i = 1; i < n; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dis[i]);
        }

        return ans;
    }
    class Pair{
        int v, wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
}
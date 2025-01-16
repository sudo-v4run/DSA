class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {

        int ans = -1;

        int lo = 1;
        int hi = (int)1e6;
        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(isPossible(n,edges,mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return ans;
    }
    public boolean isPossible(int n, int edges[][], int maxWt){

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];

            if(wt <= maxWt){
                adj.get(v).add(new Pair(u,wt));    // reversing the edges
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        HashSet<Integer> vis = new HashSet<>();
        vis.add(0);
        int cnt = 1;

        while(!q.isEmpty()){
            Pair pop = q.poll();
            for(Pair nei : adj.get(pop.node)){
                if(vis.contains(nei.node)){
                    continue;
                }
                vis.add(nei.node);
                q.add(new Pair(nei.node,nei.wt));
                cnt++;
            }
            
        }

        return cnt == n;
    }
    class Pair{
        int node, wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
}
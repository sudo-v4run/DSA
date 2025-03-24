class Solution {
    public int numberOfComponents(int[][] properties, int k) {

        int n = properties.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int cur = intersect(properties[i],properties[j]);
                if(cur >= k){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int compos = 0;
        HashSet<Integer> vis = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(!vis.contains(i)){
                dfs(i,adj,vis);
                compos++;
            }
        }
        
        return compos;
    }
    public int intersect(int a[], int b[]){

        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for(int x : a){
            hs1.add(x);
        }
        for(int x : b){
            hs2.add(x);
        }

        int cnt = 0;

        for(int x : hs1){
            if(hs2.contains(x)){
                cnt++;
            }
        }

        return cnt;
    }
    public void dfs(int v, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis){

        if(vis.contains(v)){
            return;
        }

        vis.add(v);

        for(int nei : adj.get(v)){
            dfs(nei,adj,vis);
        }
    }
}
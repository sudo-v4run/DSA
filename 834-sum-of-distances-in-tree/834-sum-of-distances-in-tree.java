class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        
        if(n==1){
            return new int[]{0};
        }
        
        for(int i = 0 ; i < n ; i++){
            adj.put(i,new ArrayList<Integer>());
        }
        
        for(int row[] : edges){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        
        int cnt[] = new int[n];
        int res[] = new int[n];
        
        postdfs(0,adj,cnt,res,-1);
        
        res[0] -= cnt[0];
        
        f(0,adj,cnt,res,-1,n);
        
        return res;
    }
    public static void postdfs( int root, HashMap<Integer,ArrayList<Integer>> adj,
                                int cnt[], int res[], int prev ){
        
        if(adj.containsKey(root)){
            for(int child : adj.get(root)){
                if(child == prev)
                    continue;
                
                postdfs(child,adj,cnt,res,root);
                cnt[root] += cnt[child];
            }
        }
        
        cnt[root]++;
        res[0] += cnt[root];
    }
    
    public static void f( int root, HashMap<Integer,ArrayList<Integer>> adj,
                                int cnt[], int res[], int prev, int n ){
        
        if(adj.containsKey(root)){
            for(int child : adj.get(root)){
                if(child == prev)
                    continue;
                
                res[child] = res[root] - cnt[child] + (n - cnt[child]);
                f(child,adj,cnt,res,root,n);
            }
        }
    }
}
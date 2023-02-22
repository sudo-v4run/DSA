class Solution {
    
    static int cnt[];
    static int res[];
    static HashMap<Integer,ArrayList<Integer>> adj;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        if(n==1){
            return new int[]{0};
        }
        adj = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.put(i,new ArrayList<Integer>());
        }
        
        for(int row[] : edges){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        
        cnt = new int[n];
        res = new int[n];
        
        postdfs(0,-1);
        res[0] -= cnt[0];
        f(0,-1,n);
        
        return res;
    }
    public static void postdfs(int root, int prev){
        
        if(adj.containsKey(root)){
            for(int child : adj.get(root)){
                
                if(child == prev)
                    continue;
                
                postdfs(child,root);
                cnt[root] += cnt[child];
            }
        }
        
        cnt[root]++;
        res[0] += cnt[root];
    }
    
    public static void f(int root, int prev, int n){
        
        if(adj.containsKey(root)){
            for(int child : adj.get(root)){
                
                if(child == prev)
                    continue;
                
                res[child] = res[root] - cnt[child] + (n - cnt[child]);
                f(child,root,n);
            }
        }
    }
}
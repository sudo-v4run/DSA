class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int ed[] : invocations){
            adj.get(ed[0]).add(ed[1]);
        }
        
        HashSet<Integer> sus = new HashSet<>();
        dfs(k,adj,sus);
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            res.add(i);
        }
        
        for(int i = 0 ; i < n ; i++){
            if(!sus.contains(i)){
                for(int nei : adj.get(i)){
                    if(sus.contains(nei)){
                        return res;
                    }
                }
            }
        }
        
        res = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            if(!sus.contains(i)){
                res.add(i);
            }
        }
        
        return res;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> sus){
        
        sus.add(node);
        
        for(int nei : adj.get(node)){
            if(!sus.contains(nei)){
                dfs(nei,adj,sus);
            }
        }
    }
}



// class Solution {
//     public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i = 0 ; i < n ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int ed[] : invocations){
//             adj.get(ed[0]).add(ed[1]);
//         }
        
//         HashSet<Integer> sus = new HashSet<>();
//         HashSet<Integer> vis = new HashSet<>();
//         dfs(k,adj,sus,vis);
        
//         int isReachable[] = new int[n];
//         Arrays.fill(isReachable,-1);
//         vis = new HashSet<>();
        
//         for(int i = 0 ; i < n ; i++){
//             if(!sus.contains(i) && !vis.contains(i)){
//                 dfs2(i,adj,sus,vis,isReachable);
//             }
//         }

//         List<Integer> res = new ArrayList<Integer>();
//         for(int i = 0 ; i < n ; i++){
//             res.add(i);
//         }
//         for(int i = 0 ; i < n ; i++){
//             if(isReachable[i] == 1){
//                 return res;
//             }
//         }
//         res = new ArrayList<Integer>();
//         for(int i = 0 ; i < n ; i++){
//             if(!sus.contains(i)){
//                 res.add(i);
//             }
//         }
        
//         return res;
//     }
//     public void dfs(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> sus, 
//                    HashSet<Integer> vis){
        
//         vis.add(node);
//         sus.add(node);
        
//         for(int nei : adj.get(node)){
//             if(!vis.contains(nei)){
//                 dfs(nei,adj,sus,vis);
//             }
//         }
//     }
//     public void dfs2(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> sus, 
//                    HashSet<Integer> vis, int isReachable[]){
        
//         vis.add(node);
        
//         for(int nei : adj.get(node)){
            
//             if(sus.contains(nei)){
//                 isReachable[node] = 1;
//             }
            
//             if(vis.contains(nei)){
//                 if(isReachable[node] != 1){
//                     isReachable[node] = isReachable[nei];
//                 }
//             }else{
//                 dfs2(nei,adj,sus,vis,isReachable);
//             }
//         }
        
//         if(isReachable[node] == -1){
//             isReachable[node] = 0;
//         }
//     }
// }
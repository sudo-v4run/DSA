class Solution {
    
    static ArrayList<ArrayList<Pair>> adj;
    static HashMap<Integer,Integer> maskFreq;
    static int nodeStr[];
    
    static class Pair{
        int node;
        char ch;
        
        Pair(int node, char ch){
            this.node = node;
            this.ch = ch;
        }
    }
    
    public long countPalindromePaths(List<Integer> parent, String s) {
        
        int n = parent.size();
        
        adj = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 1 ; i < n ; i++){
            int u = parent.get(i);
            int v = i;
            
            adj.get(u).add(new Pair(v,s.charAt(i))); 
                    // don't need to add v-u coz we will only traverse 
                    // from root to all other nodes but not reverse..
        }
        
        maskFreq = new HashMap<>();
        nodeStr = new int[n];
        
        int mask = 0;
        
        dfs(0,0);
        
        long ans = 0; 
        
        for(int i = 0 ; i < n ; i++){
            int u = nodeStr[i];
            for(int j = 0 ; j < 26 ; j++){
                int umaskv = u ^ (1 << j);
                
                ans += maskFreq.getOrDefault(umaskv,0);
            }
            if(maskFreq.containsKey(u)){
                ans += maskFreq.get(u)-1;   // -1 for u -> u
            }
        }
        
        return ans/2;
    }
    public static void dfs(int v, int mask){
        
        maskFreq.put(mask,maskFreq.getOrDefault(mask,0)+1);
        nodeStr[v] = mask;
        
        for(Pair adjnode : adj.get(v)){
            int node = adjnode.node;
            char ch = adjnode.ch;
            
            int newMask = mask ^ (1 << (ch-'a'));
            
            dfs(node,newMask);
        }
    }
}
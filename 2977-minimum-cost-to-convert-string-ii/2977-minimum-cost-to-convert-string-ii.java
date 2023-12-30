class Solution {
    class Pair{
        int node,cst;
        Pair(int node, int wt){
            this.node = node;
            this.cst = cst;
        }
    }
    HashMap<String,Integer> sToInt;
    long dist[][];
    HashSet<Integer> lengths;
    public long minimumCost(String source, String target, 
                            String[] original, String[] changed, int[] cost) {
        
        int originalLen = original.length;
        int changedLen = changed.length;
        
        sToInt = new HashMap<>();
        int label = 0;
        for(int i = 0 ; i < originalLen ; i++){
            if(!sToInt.containsKey(original[i])){
                sToInt.put(original[i],label++);
            }
        }
        
        for(int i = 0 ; i < changedLen ; i++){
            if(!sToInt.containsKey(changed[i])){
                sToInt.put(changed[i],label++);
            }
        }
        
        int n = sToInt.size();
        
        dist = new long[n][n];
        for(long row[] : dist){
            Arrays.fill(row,(long)1e15);
        }
        
        for(int i = 0 ; i < originalLen ; i++){
            int u = sToInt.get(original[i]);
            int v = sToInt.get(changed[i]);
            
            dist[u][v] = Math.min(dist[u][v],cost[i]);
        }
        
        // Floyd Warshall's Algo...
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
            }
        }
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    
                    if(dist[i][k] == (long)1e15 || dist[k][j] == (long)1e15){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        lengths = new HashSet<>();
        for(String e : original){
            lengths.add(e.length());
        }
        
        long dp[] = new long[source.length()];
        Arrays.fill(dp,-1);
        
        long ans = f(0,source,target,dp);
        
        if(ans == (long)1e15){
            return -1;
        }
        
        return ans;
    }
    public long f(int index, String s, String t, long dp[]){
        
        int n = s.length();
        
        if(index >= n){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        long ans = (long)1e15;
        
        if(s.charAt(index) == t.charAt(index)){
            ans = f(index+1,s,t,dp);
        }
        
        for(int length : lengths){
            
            if(index+length > n){
                continue;
            }
            
            String srcTemp = s.substring(index,index+length);
            String targetTemp = t.substring(index,index+length);
            
            int srcTempNode = sToInt.getOrDefault(srcTemp,-1);
            int targetTempNode = sToInt.getOrDefault(targetTemp,-1);
            
            if(srcTempNode == -1 || targetTempNode == -1){
                continue;
            }
            
            long cur = dist[srcTempNode][targetTempNode] + f(index+length,s,t,dp);
            
            ans = Math.min(ans,cur);
        }
        
        return dp[index] = ans;
    }
}
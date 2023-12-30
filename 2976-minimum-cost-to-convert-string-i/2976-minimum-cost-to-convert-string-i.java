// Using Dijkstra... You can do the same using Floyd Warshall's Algo...
// Refer Minimum Cost to Convert String II for Warshall's Algo...

class Solution{
    class Pair{
        int node, cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public long minimumCost(String source, String target, 
                            char[] original, char[] changed, int[] cost){
        
        int dist[][] = new int[26][26];
        for(int row[] : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < original.length ; i++){
            
            int u = original[i]-'a';
            int v = changed[i]-'a';
            
            adj.get(u).add(new Pair(v,cost[i]));
        }
        
        // Since we are pre-computing shortest dist from every alphabet/node to every 
        // other alphabet/node, and there is no as such destination node, we are 
        // using q insted of PQ. Because we don't stop when node == dest -> coz there is 
        // no dest.
        
        for(int i = 0 ; i < original.length ; i++){
            int curSrc = original[i]-'a';
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(curSrc,0));

            while(!q.isEmpty()){
                Pair p = q.poll();
                int node = p.node;
                int nodeCost = p.cost;

                for(Pair nei : adj.get(node)){
                    int adjNode = nei.node;
                    int adjCost = nodeCost+nei.cost;
                    if(dist[curSrc][adjNode] > adjCost){
                        dist[curSrc][adjNode] = adjCost;
                        q.add(new Pair(adjNode,adjCost));
                    }
                }
            }
        }
        
        long ans = 0;
        for(int i = 0 ; i < source.length() ; i++){
            if(source.charAt(i) == target.charAt(i)){
                continue;
            }
            
            int curCost = dist[source.charAt(i)-'a'][target.charAt(i)-'a'];
            if(curCost == Integer.MAX_VALUE){
                return -1;
            }
            
            ans += curCost;
        }
        
        return ans;
    }
}

// Using simple PQ with DP...

// class Solution {
//     class Pair{
//         char ch;
//         long cost;
//         Pair(char ch, long cost){
//             this.ch = ch;
//             this.cost = cost;
//         }
//     }
    
//     HashMap<Character,ArrayList<Pair>> hm;
//     HashMap<Character,HashMap<Character,Long>> dp;
    
//     public long minimumCost(String source, String target, 
//                             char[] original, char[] changed, int[] cost) {
        
//         int n = source.length();
//         hm = new HashMap<>();
//         dp = new HashMap<>();
        
//         for(int i = 0 ; i < original.length ; i++){
//             if(!hm.containsKey(original[i])){
//                 hm.put(original[i],new ArrayList<>());
//             }
//             hm.get(original[i]).add(new Pair(changed[i],cost[i]));
//         }
        
//         long res = 0;
        
//         for(int i = 0 ; i < n ; i++){
//             if(source.charAt(i) == target.charAt(i)){
//                 continue;
//             }
//             long curCharCost = f(source.charAt(i),target.charAt(i));
//             if(curCharCost == (long)1e15){
//                 return -1;
//             }
            
//             res += curCharCost;
//         }
        
//         return res;
//     }
//     public long f(char s, char t){
        
//         if(dp.containsKey(s) && dp.get(s).containsKey(t)){
//             return dp.get(s).get(t);
//         }
        
//         HashSet<Character> vis = new HashSet<>();
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
//             return (int)(a.cost-b.cost);
//         });
//         pq.add(new Pair(s,0));
        
//         while(!pq.isEmpty()){
            
//             Pair pop = pq.poll();
//             char node = pop.ch;
//             long cost = pop.cost;
            
//             if(node == t){
//                 if(!dp.containsKey(s)){
//                     dp.put(s,new HashMap<>());
//                 }
//                 dp.get(s).put(node,cost);
//                 return cost;
//             }
            
//             if(!vis.contains(node)){
//                 vis.add(node);
//                 if(!dp.containsKey(s)){
//                     dp.put(s,new HashMap<>());
//                 }
//                 dp.get(s).put(node,cost);
//                 if(!hm.containsKey(node)){
//                     continue;
//                 }
//                 for(Pair p : hm.get(node)){
//                     pq.add(new Pair(p.ch,cost+p.cost));
//                 }
//             }
            
//         }
        
//         return (long)1e15;
//     }
// }
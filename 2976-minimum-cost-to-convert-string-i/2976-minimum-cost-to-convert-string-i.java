class Solution {
    class Pair{
        char ch;
        long cost;
        Pair(char ch, long cost){
            this.ch = ch;
            this.cost = cost;
        }
    }
    
    HashMap<Character,ArrayList<Pair>> hm;
    HashMap<Character,HashMap<Character,Long>> dp;
    
    public long minimumCost(String source, String target, 
                            char[] original, char[] changed, int[] cost) {
        
        int n = source.length();
        hm = new HashMap<>();
        dp = new HashMap<>();
        
        for(int i = 0 ; i < original.length ; i++){
            if(!hm.containsKey(original[i])){
                hm.put(original[i],new ArrayList<>());
            }
            hm.get(original[i]).add(new Pair(changed[i],cost[i]));
        }
        
        long res = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(source.charAt(i) == target.charAt(i)){
                continue;
            }
            long curCharCost = f(source.charAt(i),target.charAt(i));
            if(curCharCost == (long)1e15){
                return -1;
            }
            
            res += curCharCost;
        }
        
        return res;
    }
    public long f(char s, char t){
        
        if(dp.containsKey(s) && dp.get(s).containsKey(t)){
            return dp.get(s).get(t);
        }
        
        HashSet<Character> vis = new HashSet<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return (int)(a.cost-b.cost);
        });
        pq.add(new Pair(s,0));
        
        while(!pq.isEmpty()){
            
            Pair pop = pq.poll();
            char node = pop.ch;
            long cost = pop.cost;
            
            if(node == t){
                if(!dp.containsKey(s)){
                    dp.put(s,new HashMap<>());
                }
                dp.get(s).put(node,cost);
                return cost;
            }
            
            if(!vis.contains(node)){
                vis.add(node);
                if(!dp.containsKey(s)){
                    dp.put(s,new HashMap<>());
                }
                dp.get(s).put(node,cost);
                if(!hm.containsKey(node)){
                    continue;
                }
                for(Pair p : hm.get(node)){
                    pq.add(new Pair(p.ch,cost+p.cost));
                }
            }
            
        }
        
        return (long)1e15;
    }
}
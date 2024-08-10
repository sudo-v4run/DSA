class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        
        int cnt = 0;
        
        HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        
        for(int p[] : pick){
            
            int x = p[0];
            int c = p[1];
            
            if(!hm.containsKey(x)){
                hm.put(x, new HashMap<>());
            }
            
            hm.get(x).put(c,hm.get(x).getOrDefault(c,0)+1);
            
            if(hm.get(x).get(c) > x && !vis.contains(x)){
                cnt++;
                vis.add(x);
            }
        }
        
        return cnt;
    }
}
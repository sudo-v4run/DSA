class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n-1 ; i++){
            hm.put(i,i+1);
        }
        
        int res[] = new int[queries.length];
        int index = 0;
        
        for(int q[] : queries){
            int u = q[0];
            int v = q[1];
            
            if(!hm.containsKey(u) || v <= hm.get(u)){
                res[index++] = hm.size();
                continue;
            }
            
            Integer i = hm.get(u);
            while(i != null && i < v){
                Integer temp = hm.get(i);
                hm.remove(i);
                i = temp;
            }
            
            res[index++] = hm.size();
            
            hm.put(u,v);
        }
        
        return res;
    }
}
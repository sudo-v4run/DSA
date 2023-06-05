class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        
        HashSet<Integer> rvis = new HashSet<>();
        HashSet<Integer> cvis = new HashSet<>();
        
        int rows = n;
        int cols = n;
        
        long ans = 0;
        
        for(int i = queries.length-1 ; i >= 0 ; i--){
            int type = queries[i][0];
            int ind = queries[i][1];
            int val = queries[i][2];

            if(type == 0 && !rvis.contains(ind)){
                ans += n*val - val*cvis.size();
                rvis.add(ind);
            }else if(type == 1 && !cvis.contains(ind)){
                ans += n*val - val*rvis.size();
                cvis.add(ind);
            }
        }
        
        return ans;
    }
}
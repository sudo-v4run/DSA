class Solution {
    int dist[][];
    public int maxDistance(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        dist = new int[m][n];
        for(int row[] : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        Queue<Triple> q = new LinkedList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(arr[i][j] == 0){
                    continue;
                }

                q.add(new Triple(i,j,0));
            }
        }

        HashSet<String> vis = new HashSet<>();

        while(!q.isEmpty()){

            Triple pop = q.poll();
            int r = pop.r;
            int c = pop.c;
            int d = pop.d;

            if(r < 0 || r >= m || c < 0 || c >= n){
                continue;
            }
            if(dist[r][c] <= d){
                continue;
            }
            if(vis.contains(r+","+c)){
                continue;
            }

            dist[r][c] = Math.min(dist[r][c],d);

            vis.add(r+","+c);

            q.add(new Triple(r-1,c,d+1));
            q.add(new Triple(r,c-1,d+1));
            q.add(new Triple(r+1,c,d+1));
            q.add(new Triple(r,c+1,d+1));
        }

        int ans = -(int)1e7;

        for(int row[] : dist){
            for(int x : row){
                if(x == Integer.MAX_VALUE){
                    continue;
                }
                ans = Math.max(ans,x);
            }
        }

        if(ans == -(int)1e7 || ans == 0){
            return -1;
        }

        return ans;
    }
    class Triple{
        
        int r, c, d;

        Triple(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
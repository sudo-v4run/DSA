class Solution {
    
    static class Tuple{
        int t;
        int r;
        int c;
        
        Tuple(int t, int r, int c){
            this.t = t;
            this.r = r;
            this.c = c;
        }
    }
    
    public int minimumTime(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][1] >1 && grid[1][0] > 1){
            return -1;
        }
        
        int vis[][] = new int[m][n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->{return a.t - b.t;});
        
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        
        pq.add(new Tuple(0,0,0));
        
        while(!pq.isEmpty()){
            Tuple pop = pq.poll();
            
            int time = pop.t;
            int row = pop.r;
            int col = pop.c;
            
            if(row == m-1 && col == n-1){
                return time;
            }
            
            if(vis[row][col] == 1){
                continue;
            }
            
            vis[row][col] = 1;
            
            for(int d[] : dir){
                
                int nr = row+d[0];
                int nc = col+d[1];
                
                if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                    continue;
                }
                
                int wait = (Math.abs(grid[nr][nc] - time) % 2 == 0) ? 1 : 0;
                int nt = Math.max(grid[nr][nc]+wait,time+1);
                pq.add(new Tuple(nt,nr,nc));
            }
            
        }
        
        return -1;
    }
}
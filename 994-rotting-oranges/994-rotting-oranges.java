class Solution {
    
    static class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;
        
        Queue<Pair> q = new LinkedList<>();
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        int time = 0;
        
        while(!q.isEmpty()){
            boolean flag = false;
            int sz = q.size();
            for(int i = 0 ; i < sz ; i++){
                Pair pop = q.poll();
                for(int d[] : dir){
                    int nr = pop.r + d[0];
                    int nc = pop.c + d[1];
                    
                    if(nr < 0 || nr >= m || nc < 0 || nc >= n){
                        continue;
                    }
                    
                    if(grid[nr][nc] == 1){
                        fresh--;
                        flag = true;
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            if(flag){
                time++;
            }
        }
        
        if(fresh != 0){
            return -1;
        }
        
        return time;
    }
}
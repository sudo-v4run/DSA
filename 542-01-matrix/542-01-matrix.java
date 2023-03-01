class Solution {
    
    static class Tuple{
        int r;
        int c;
        int d;
        Tuple(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<Tuple> q = new LinkedList<>();
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int vis[][] = new int[m][n];
        
        int res[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    q.add(new Tuple(i,j,0));
                }
            }
        }
        
        while(!q.isEmpty()){
            Tuple pop = q.poll();
            int row = pop.r;
            int col = pop.c;
            int dist = pop.d;
            
            if(mat[row][col] == 1){
                if(res[row][col] == 0){
                    res[row][col] = dist;
                }else{
                    res[row][col] = Math.min(res[row][col],dist);
                }
            }
            
            vis[row][col] = 1;
            
            for(int d[] : dir){
                int nr = row + d[0];
                int nc = col + d[1];
                
                if( nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc] == 1 ||
                    mat[nr][nc] == 0 ){
                    
                    continue;
                }
                
                q.add(new Tuple(nr,nc,dist+1));
            }
        }
        
        return res;
    }
}
class Solution {
    
    static class Pair{
        int r,c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int shortestPathBinaryMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        if(arr[0][0] == 1){
            return -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        
        int vis[][] = new int[m][n];
        vis[0][0] = 1;
        
        int steps = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            for(int i = 0 ; i < sz ; i++){
                Pair pop = q.poll();
                int r = pop.r;
                int c = pop.c;
                
                if(r == m-1 && c == n-1){
                    return steps;
                }
                
                for(int delr = -1 ; delr <= 1 ; delr++){
                    for(int delc = -1 ; delc <= 1 ; delc++){
                        int nr = r+delr;
                        int nc = c+delc;

                        if( nr < 0 || nr >= m || nc < 0 || nc >= n || 
                            vis[nr][nc] == 1 || arr[nr][nc] == 1 ){

                                continue;
                        }

                        vis[nr][nc] = 1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
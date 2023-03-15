class Solution {
    static class Tuple{
        int r,c,diff;
        
        Tuple(int r,int c,int diff){
            this.r = r;
            this.c = c;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights){
        
        int m = heights.length;
        int n = heights[0].length;
        
        int efforts[][] = new int[m][n];
        for(int row[] : efforts){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        
        int dir[][] = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->{return (a.diff-b.diff);});
        pq.add(new Tuple(0,0,0));
        
        while(!pq.isEmpty()){
            
            Tuple pop = pq.poll();
            int r = pop.r;
            int c = pop.c;
            int diff = pop.diff;
            
            if(r == m-1 && c == n-1){
                break;
            }
            
            for(int d[] : dir){
                
                int nr = r + d[0];
                int nc = c + d[1];
                
                if( nr < 0 || nr >= m || nc < 0 || nc >= n ){
                    continue;
                }
                
                int adjDiff = Math.abs(heights[r][c] - heights[nr][nc]);
                int newDiff = Math.max(adjDiff,diff);
                
                if(newDiff < efforts[nr][nc]){
                    efforts[nr][nc] = newDiff;
                    pq.add(new Tuple(nr,nc,newDiff));
                }
            }
        }
        
        return efforts[m-1][n-1];
    }
}
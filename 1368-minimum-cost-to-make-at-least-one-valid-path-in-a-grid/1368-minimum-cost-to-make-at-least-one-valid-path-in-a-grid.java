class Solution {
    public int minCost(int[][] arr) {
        
        // Dijsktra's

        int m = arr.length;
        int n = arr[0].length;

        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        int dist[][] = new int[m][n];
        for(int row[] : dist){
            Arrays.fill(row,(int)1e5);
        }
        dist[0][0] = 0;

        int vis[][] = new int[m][n];

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Triplet(0,0,0));

        while(!pq.isEmpty()){
            Triplet pop = pq.poll();

            int cost = pop.cost;
            int row = pop.r;
            int col = pop.c;

            vis[row][col] = 1;

            if(row == m-1 && col == n-1){
                return cost;
            }

            for(int d = 0; d < 4; d++){
                int newR = row+dir[d][0];
                int newC = col+dir[d][1];

                if(newR < 0 || newR >= m || newC < 0 || newC >= n || vis[newR][newC] == 1){
                    continue;
                }

                int curCost = 0;
                if(arr[row][col] != d+1){
                    curCost = 1;
                }

                if(cost + curCost < dist[newR][newC]){
                    dist[newR][newC] = cost + curCost;
                    pq.add(new Triplet(dist[newR][newC],newR,newC));
                }
            }
        }

        return dist[m-1][n-1];
    }
    class Triplet{
        int cost, r, c;
        Triplet(int cost, int r, int c){
            this.cost = cost;
            this.r = r;
            this.c = c;
        }
    }
}
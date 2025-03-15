class Solution {

    Queue<Pair> q;
    HashSet<String> vis;
    int dirs[][];

    public int shortestBridge(int[][] arr){
        
        int m = arr.length;
        int n = arr[0].length;

        q = new LinkedList<>();
        vis = new HashSet<>();
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        boolean flag = false;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    flag = true;
                    dfs(i,j,arr);
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        int steps = 0;

        while(!q.isEmpty()){

            int sz = q.size();

            for(int i = 0 ; i < sz ; i++){

                Pair pop = q.poll();
                int r = pop.r;
                int c = pop.c;

                for(int d[] : dirs){
                    int newR = r+d[0];
                    int newC = c+d[1];

                    if(newR < 0 || newR >= m || newC < 0 || newC >= n || vis.contains(newR+","+newC)){
                        continue;
                    }

                    if(arr[newR][newC] == 1){
                        return steps;
                    }

                    q.add(new Pair(newR,newC));
                    vis.add(newR+","+newC);
                }
            }

            steps++;
        }

        return -1;
    }
    public void dfs(int r, int c, int arr[][]){

        int m = arr.length;
        int n = arr[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || vis.contains(r+","+c)){
            return;
        }
        if(arr[r][c] == 0){
            return;
        }
        
        q.add(new Pair(r,c));
        vis.add(r+","+c);

        dfs(r-1,c,arr);
        dfs(r,c-1,arr);
        dfs(r+1,c,arr);
        dfs(r,c+1,arr);
    }
    
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
class Solution {
    Queue<Pair> q;
    public int shortestBridge(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;

        q = new LinkedList<>();

        boolean flag = false;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    dfs(i,j,arr);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        HashSet<String> vis = new HashSet<>();

        int steps = 0;

        while(!q.isEmpty()){

            int sz = q.size();

            for(int i = 0 ; i < sz ; i++){

                Pair pop = q.poll();
                int r = pop.r;
                int c = pop.c;
                int dist = pop.dist;

                if(r < 0 || r >= m || c < 0 || c >= n){
                    continue;
                }
                if(arr[r][c] == 1){
                    return steps-1;
                }

                if(vis.contains(r+","+c)){
                    continue;   
                }
                vis.add(r+","+c);

                q.add(new Pair(r-1,c,dist+1));
                q.add(new Pair(r,c-1,dist+1));
                q.add(new Pair(r+1,c,dist+1));
                q.add(new Pair(r,c+1,dist+1));
            }

            steps++;
        }

        return -1;
    }
    public void dfs(int r, int c, int arr[][]){

        int m = arr.length;
        int n = arr[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n){
            return;
        }
        if(arr[r][c] == 2){
            return;
        }
        if(arr[r][c] == 0){
            return;
        }

        arr[r][c] = 2;
        q.add(new Pair(r,c,0));

        dfs(r-1,c,arr);
        dfs(r,c-1,arr);
        dfs(r+1,c,arr);
        dfs(r,c+1,arr);
    }
    
    class Pair{
        int r, c, dist;
        Pair(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
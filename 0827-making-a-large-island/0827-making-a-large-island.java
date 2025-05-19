class Solution {
    public int largestIsland(int[][] arr) {

        int n = arr.length;

        HashMap<Integer,Integer> area = new HashMap<>();
        int id = 2;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    int cur = f(i, j, id, arr);
                    System.out.println(cur);
                    area.put(id,cur);
                    id++;
                }
            }
        }

        int max = 0;
        boolean zeroExists = false;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 0){
                    zeroExists = true;

                    HashSet<Integer> vis = new HashSet<>();

                    int cur = 1;
                    if(i-1 >= 0 && !vis.contains(arr[i-1][j])){
                        cur += area.getOrDefault(arr[i-1][j],0);
                        vis.add(arr[i-1][j]);
                    }
                    if(j-1 >= 0 && !vis.contains(arr[i][j-1])){
                        cur += area.getOrDefault(arr[i][j-1],0);
                        vis.add(arr[i][j-1]);
                    }
                    if(i+1 < n && !vis.contains(arr[i+1][j])){
                        cur += area.getOrDefault(arr[i+1][j],0);
                        vis.add(arr[i+1][j]);
                    }
                    if(j+1 < n && !vis.contains(arr[i][j+1])){
                        cur += area.getOrDefault(arr[i][j+1],0);
                        vis.add(arr[i][j+1]);
                    }

                    max = Math.max(max,cur);
                }
            }
        }

        if(!zeroExists){
            return n*n;
        }

        return max;
    }
    public int f(int r, int c, int id, int arr[][]){

        int n = arr.length;

        if(r < 0 || r >= n || c < 0 || c >= n){
            return 0;
        }

        if(arr[r][c] != 1){
            return 0;
        }

        arr[r][c] = id;

        int up = f(r-1,c,id,arr);     
        int left = f(r,c-1,id,arr);
        int down = f(r+1,c,id,arr);
        int right = f(r,c+1,id,arr);

        return 1+up+down+left+right;
    }
}
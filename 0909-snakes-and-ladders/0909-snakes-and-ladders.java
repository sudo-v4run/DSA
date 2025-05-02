class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length;

        for(int i = 0 ; i < (n/2) ; i++){
            int temp[] = board[i];
            board[i] = board[n-1-i];
            board[n-1-i] = temp;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(1);

        int moves = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int index = 0 ; index < sz ; index++){
                int sq = q.poll();
                if(sq == n*n){
                    return moves;
                }
                for(int i = 1 ; i <= 6 && sq+i <= n*n ; i++){
                    int nextSq = sq+i;
                    Pair pos = intToPos(nextSq, n);
                    int r = pos.r;
                    int c = pos.c;
                    if(board[r][c] != -1){
                        nextSq = board[r][c];
                    }
                    if(vis.contains(nextSq)){
                        continue;
                    }
                    q.add(nextSq);
                    vis.add(nextSq);
                }
            }
            moves++;
        }

        return -1;
    }
    public Pair intToPos(int sq, int n){

        int r = (sq-1)/n;
        int c = (sq-1)%n;

        if(r%2 == 1){
            c = n-1-c;
        }

        return new Pair(r, c);
    }
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
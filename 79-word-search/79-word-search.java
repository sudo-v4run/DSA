class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        int vis[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(f(i,j,0,board,word,vis))
                    return true;
            }
        }
        
        
        return false;
    }
    public static boolean f(int r,int c,int wordInd, 
                                char[][] board,String word, int[][] vis){
        
        if(wordInd>=word.length())
            return true;
        
        if(r<0 || r>= board.length || c<0 || c>= board[0].length)
            return false;
        
        if(vis[r][c]==1)
            return false;
        
        
        
        if(word.charAt(wordInd)!=board[r][c])
            return false;
        
        vis[r][c] = 1;
            
        if(f(r-1,c,wordInd+1,board,word,vis) ||
           f(r+1,c,wordInd+1,board,word,vis) ||
           f(r,c-1,wordInd+1,board,word,vis) ||
           f(r,c+1,wordInd+1,board,word,vis)){
            
            return true;
        }
        
        vis[r][c] = 0;
        
        return false;
    }
}
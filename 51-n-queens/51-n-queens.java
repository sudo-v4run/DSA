class Solution {
    
    static List<List<String>> res;
    
    public List<List<String>> solveNQueens(int n) {
        
        res = new ArrayList<>();
        
        int matrix[][] = new int[n][n];
        
        f(0,matrix);
        
        return res;
    }
    public static void f(int row, int matrix[][]){
        
        if(row == matrix.length){
            
            ArrayList<String> ans = new ArrayList<>();
            
            for(int i = 0 ; i < matrix.length ; i++){
                String s = "";
                for(int j = 0 ; j < matrix.length ; j++){
                    if(matrix[i][j] == 1){
                        s += "Q";
                    }else{
                        s += ".";
                    }
                }
                ans.add(s);
            }
            
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int col = 0 ; col < matrix.length ; col++){
            if(isPossible(row,col,matrix)){
                matrix[row][col] = 1;
                f(row+1,matrix);
            }
            matrix[row][col] = 0;
        }
    }
    public static boolean isPossible(int r, int c, int matrix[][]){
        
        int n = matrix.length;
        
        for(int i = 0 ; i < n ; i++){
            if(matrix[r][i] == 1){
                return false;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(matrix[i][c] == 1){
                return false;
            }
        }
        
        int i = r;
        int j = c;
        
        while(i >= 0 && j >= 0){
            if(matrix[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        
        i = r;
        j = c;
        
        while(i >= 0 && j < n){
            if(matrix[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int curRow = 0;
        int curCol = n-1;
        
        while(curRow<m && curCol>=0){
            if(matrix[curRow][curCol]==target){
                return true;
            }
            
            if(target<matrix[curRow][curCol]){
                curCol--;
            }else{
                curRow++;
            }
            
        }
        
        return false;
    }
}
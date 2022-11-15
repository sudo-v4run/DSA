class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int right = 0;
        int down = 1;
        int left = 2;
        int up = 3;
        
        int dir = right;
        
        int topRow = 0;
        int rightCol = n-1;
        int buttomRow = m-1;
        int leftCol = 0;
        
        while((topRow<=buttomRow) && (leftCol<=rightCol)){
            if(dir==right){
                for(int i = leftCol ; i<= rightCol ; i++){
                    res.add(matrix[topRow][i]);
                }
                topRow++;
                dir = down;
            }else if(dir==down){
                for(int i = topRow ; i <= buttomRow ; i++){
                    res.add(matrix[i][rightCol]);
                }
                rightCol--;
                dir = left;
            }else if(dir==left){
                for(int i = rightCol ; i >= leftCol ; i--){
                    res.add(matrix[buttomRow][i]);
                }
                buttomRow--;
                dir = up;
            }else{
                for(int i = buttomRow ; i >= topRow ; i--){
                    res.add(matrix[i][leftCol]);
                }
                leftCol++;
                dir = right;
            }
        }
        
        return res;
    }
}
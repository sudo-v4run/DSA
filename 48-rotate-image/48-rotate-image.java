class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = i ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int row[] : matrix){
            int s = 0;
            int e = n-1;
            while(s<=e){
                swap(row,s,e);
                s++;
                e--;
            }
        }    
    }
    
    public static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
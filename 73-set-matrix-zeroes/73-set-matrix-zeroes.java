class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean col0 = false;
        
        for(int i = 0 ; i < m ; i++){
            if(arr[i][0]==0)
                col0=true;
            for(int j = 1; j < n ; j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }
        
        for(int i = m-1 ; i >=0;i--){
            for(int j = n-1; j >=1;j--){
                if(arr[i][0]==0||arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
            if(col0){
                arr[i][0]=0;
            }
        }
    }
//         int m = arr.length;
//         int n = arr[0].length;
//         int res[][] = new int[m][n];
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 res[i][j]=-1;
//             }
//         }
      
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(arr[i][j]==0){
//                     makeItZero(res,i,j,m,n);
//                 }
//             }
//         }
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(res[i][j]==0){
//                    arr[i][j]=res[i][j];
                   
//                 }
//             }
//         }
//     }
//     public static void makeItZero(int res[][],int i , int j,int m, int n){
//         for(int k = 0 ; k < n ; k++){
//             res[i][k]=0;
//         }
//         for(int k = 0 ; k < m ; k++){
//             res[k][j]=0;
//         }
//     }
}
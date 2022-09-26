class Solution {
    public void setZeroes(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        
        boolean zeroInC0 = false;
        
        for(int i = 0 ; i < r ; i++){
            if(arr[i][0]==0)
                zeroInC0 = true;
            for(int j = 1 ; j < c ; j++){
                if(arr[i][j]==0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        for(int i = r-1 ; i >=0 ; i--){
            for(int j = c-1 ; j >=1 ; j--){
                if(arr[i][0]==0||arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
            if(zeroInC0)
                arr[i][0] = 0;
        }
        
        
        
        
        
        
        
       
//         int b[][] = new int[r][c];
        
//         for(int i = 0 ; i < r ; i++){
//             for(int j = 0 ; j < c ; j++){
//                 b[i][j] = -1;
//             }
//         }
        
//         for(int i = 0 ; i < r ; i++){
//             for(int j = 0 ; j < c ; j++){
//                 if(arr[i][j]==0){
//                     put0inb(b,i,j);
//                 }
//             }
//         }
        
//         for(int i = 0 ; i < r ; i++){
//             for(int j = 0 ; j < c; j++){
//                 if(b[i][j]==0){
//                     arr[i][j]=0;
//                 }
//             }
//         }
    }
    
//     public static void put0inb(int b[][],int r,int c){
//         for(int i = 0 ; i < b[0].length ; i++){
//             b[r][i] = 0;
//         }
        
//         for(int i = 0 ; i < b.length ; i++){
//             b[i][c] = 0;
//         }
//     }
    
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int s = 0;
        int e = m*n-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(target==matrix[mid/n][mid%n])
                return true;
            
            if(target<matrix[mid/n][mid%n]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        
        return false;
        
        
        
//         int mc = n/2;
        
//         if(m==1){
//             return bs(matrix,0,target,mc);
//         }
        
//         int rs = 0;
//         int re = m-1;
        
//         while(!(rs+1==re)){
//             int mr = rs+(re-rs)/2;
            
//             if(matrix[mr][mc]==target)
//                 return true;
//             if(target<matrix[mr][mc]){
//                 re = mr;
//             }else{
//                 rs = mr;
//             }
//         }
        
//         if(bs(matrix,rs,target,mc))
//             return true;
//         return bs(matrix,re,target,mc);
        
        
    }
    public static boolean bs(int arr[][],int r,int x, int m){
        int s = 0;
        int e = arr[0].length-1;
        while(s<=e){
            if(arr[r][m]==x){
                return true;
            }
            if(x<arr[r][m]){
                e = m-1;
            }else{
                s = m+1;
            }
            m = s+(e-s)/2;
        }
        return false;
    }
}
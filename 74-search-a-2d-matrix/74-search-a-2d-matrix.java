class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // TC -> log(m+n)... Binary Search...
        
        int s = 0;
        int e = m*n-1;
        
        while(s <= e){
            int mid = s+(e-s)/2;
            int midEle = matrix[mid/n][mid%n];
            
            if(midEle == target){
                return true;
            }
            
            if(target < midEle){
                e = mid-1;
            }else{
                s = mid+1;
            }
            
        }
        
        return false;
        
        
        
        // TC -> O(m+n)...
        
//         int r = 0;
//         int c = n-1;
        
//         while(r < m && c >= 0){
//             if(matrix[r][c] == target){
//                 return true;
//             }
            
//             if(target < matrix[r][c]){
//                 c--;
//             }else{
//                 r++;
//             }
//         }
        
//         return false;
    }
}
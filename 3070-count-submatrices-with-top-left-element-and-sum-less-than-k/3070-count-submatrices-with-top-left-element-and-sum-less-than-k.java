class Solution {
    public int countSubmatrices(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int count = 0;
        
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + 
                    prefixSum[i - 1][j] + prefixSum[i][j - 1] - 
                    prefixSum[i - 1][j - 1];
                if(prefixSum[i][j] <= target){
                    count++;
                }
            }
        }

        return count;
    }
}
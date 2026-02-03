class Solution {
    public int maxSumSubmatrix(int[][] matrix, int limit) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int pre[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                int left = 0;
                int top = 0;
                int dia = 0;

                if(j-1 >= 0){
                    left = pre[i][j-1];
                }
                if(i-1 >= 0){
                    top = pre[i-1][j];
                }
                if(i-1 >= 0 && j-1 >= 0){
                    dia = pre[i-1][j-1];
                }

                pre[i][j] = matrix[i][j] + left + top - dia;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(pre[i][j] <= limit){
                    max = Math.max(max, pre[i][j]);
                }

                for(int k = -1; k <= i; k++){
                    for(int l = -1; l <= j; l++){

                        if(k == i || l == j){
                            continue;
                        }
                        
                        int top = 0;
                        if(k != -1){
                            top = pre[k][j];
                        }

                        int left = 0;
                        if(l != -1){
                            left = pre[i][l];
                        }

                        int dia = 0;
                        if(k != -1 && l != -1){
                            dia = pre[k][l];
                        }

                        int cur = pre[i][j]-top-left+dia;

                        if(cur <= limit){
                            max = Math.max(max, cur);
                        }
                    }
                }
            }
        }

        return max;
    }
}
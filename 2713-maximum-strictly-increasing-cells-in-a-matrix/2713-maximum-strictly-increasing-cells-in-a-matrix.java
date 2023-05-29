class Solution {
    public int maxIncreasingCells(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int rowMax[] = new int[m];
        int colMax[] = new int[n];
        // stores the max no of cells that can be visited in the each row and col
        
        int temp[][] = new int[m][n];
        // stores the max no of cells that can be visited from each cell
        
        HashMap<Integer,ArrayList<int[]>> positions = new HashMap<>();
        // stores each value and their positions in mat[][] in sorted order...
        TreeSet<Integer> uniqueVals = new TreeSet<>();
        // Set coz all the same values will be computed at once
        
        
        // Storing the sorted order of values...
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int val = -mat[i][j]; // to store in ascending order
                if(!positions.containsKey(val)){
                    positions.put(val,new ArrayList<>());
                }
                positions.get(val).add(new int[]{i,j});
                uniqueVals.add(val);
            }
        }
        
        // Compute the ans for each value/cell as the starting point...
        for(int curVal : uniqueVals){
            for(int[] pos : positions.get(curVal)){
                int r = pos[0];
                int c = pos[1];
                
                temp[r][c] = Math.max(rowMax[r],colMax[c])+1;
                // once we update at all the positions of curVal, we update the 
                // rowMax and colMax if needed in the next step...
                // note that updating the row/colMax here itself will change the
                // values for the next iteration (other positions) of the curVal
            }
            
            for(int[] pos : positions.get(curVal)){
                int r = pos[0];
                int c = pos[1];
                
                rowMax[r] = Math.max(rowMax[r],temp[r][c]);
                colMax[c] = Math.max(colMax[c],temp[r][c]);
                // updating if any new max value obtained in the corresponding row
                // and col
            }
        }
        
        int max = 0;
        
        for(int row[] : temp){
            for(int ele : row){
                max = Math.max(max,ele);
            }
        }
        
        return max;
        
        
        // DP sol... Giving TLE
        
//         int dp[][] = new int[m][n];
//         for(int row[] : dp){
//             Arrays.fill(row,Integer.MIN_VALUE);
//         }
        
//         int max = 0;
        
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 dfs(i,j,mat,dp);
//             }
//         }
        
//         for(int row[] : dp){
//             for(int ele : row){
//                 max = Math.max(max,ele);
//             }
//         }
        
//         return max+1;        // +1 for starting cell itself
    }
    public static int dfs(int r, int c , int arr[][], int dp[][]){
        
        if(dp[r][c] != Integer.MIN_VALUE){
            return dp[r][c];
        }
        
        int max = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i][c] > arr[r][c]){
                max = Math.max(max,1+dfs(i,c,arr,dp));
            }
        }
        
        for(int j = 0 ; j < arr[0].length ; j++){
            if(arr[r][j] > arr[r][c]){
                max = Math.max(max,1+dfs(r,j,arr,dp));
            }
        }
        
        return dp[r][c] = max;
    }
}
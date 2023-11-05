class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        boolean[] isChampion = new boolean[n];
        Arrays.fill(isChampion,true);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    isChampion[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isChampion[i]) {
                return i;
            }
        }

        return -1;
    }
}
class Solution {
public:

    int dp[100][100][100]; //THE THIRD PARAMETER COUNTS NUMBER OF CHANGES OF DIRECTION, PLEASE DON'T ASK ME WHY 57 :)))

    int dfs(vector<vector<int>> & grid, int i, int j, int n, int m, int cntr)
    {
        if(grid[i][j] == -1e6 || cntr > 56) return 1e6;

        if(dp[i][j][cntr] != -1) return dp[i][j][cntr];

        if(i == n - 1 && j == m - 1) return 0;

        int res = 1e6, tmp = grid[i][j];

        grid[i][j] = -1e6;
        
        if(j < m - 1) res = min(res, (tmp != 1) + dfs(grid, i, j + 1, n, m, cntr + (tmp != 1)));
        if(j > 0) res = min(res, (tmp != 2) + dfs(grid, i, j - 1, n, m, cntr + (tmp != 2)));
        if(i < n - 1) res = min(res, (tmp != 3) + dfs(grid, i + 1, j, n, m, cntr + (tmp != 3)));
        if(i > 0) res = min(res, (tmp != 4) + dfs(grid, i - 1, j, n, m, cntr + (tmp != 4)));

        grid[i][j] = tmp;

        return dp[i][j][cntr] = res;
    }
    int minCost(vector<vector<int>>& grid) 
    {
        int n = grid.size(), m = grid[0].size();

        memset(dp, -1, sizeof(dp));

        return dfs(grid, 0, 0, n, m, 0);
    }
};
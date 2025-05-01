class Solution {
    int minMoves;

    public int snakesAndLadders(int[][] board) {
        minMoves = Integer.MAX_VALUE;
        dfs(board, board.length * board.length, board.length, 1, 0, new HashMap<>());
        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }

    private void dfs(int[][] board, int maxPos, int sideSize, int currPos, int movesMade, Map<Integer, Integer> visited) {
        if (movesMade >= minMoves || (visited.containsKey(currPos) && movesMade >= visited.get(currPos))) {
            return;
        }
        if (currPos == maxPos) {
            minMoves = movesMade; 
            return;
        }
        visited.put(currPos, movesMade);
        for (int i = 1; i <= Math.min(6, maxPos - currPos); i++) { 
            int nextPos = currPos + i;
            int row = sideSize - 1 - (nextPos - 1) / sideSize;
            int col = (sideSize - row) % 2 == 1 ? (nextPos - 1) % sideSize : sideSize - 1 - ((nextPos - 1) % sideSize);
            dfs(board, maxPos, sideSize, board[row][col] == -1 ? nextPos : board[row][col], movesMade + 1, visited);
        }
    }
}
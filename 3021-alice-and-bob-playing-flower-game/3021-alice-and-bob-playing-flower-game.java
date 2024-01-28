class Solution {
    public long flowerGame(int n, int m) {
        
        long oddX = (m + 1) / 2;
        long oddY = (n + 1) / 2;

        long evenX = m / 2;
        long evenY = n / 2;

        return oddX * evenY + evenX * oddY;
    }
}
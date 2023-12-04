class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        
        Arrays.sort(coins);
        int maxReach = 0;  // Represents the maximum value that can be obtained from the current coins

        int minCoinsToAdd = 0;
        int i = 0;

        while (maxReach < target) {
            if (i < coins.length && coins[i] <= maxReach + 1) {
                // Extend the range by including the current coin
                maxReach += coins[i];
                i++;
            } else {
                // Add a new coin with value maxReach + 1 to extend the range
                minCoinsToAdd++;
                maxReach += (maxReach + 1);
            }
        }

        return minCoinsToAdd;
    }
}
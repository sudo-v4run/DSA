class Solution {
    public long maxWeight(int[] pizzas) {

        int n = pizzas.length;
        
        Arrays.sort(pizzas);

        int days = n/4;

        int odds = (days+1)/2;
        int evens = days-odds;

        long ans = 0;

        int i = n-1;
        while(odds > 0 && i >= 0){
            ans += pizzas[i];
            i--;
            odds--;
        }

        while(evens > 0 && i > 0){
            ans += pizzas[i-1];
            i--;
            evens--;
        }

        return ans;
    }
}
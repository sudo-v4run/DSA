class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        
        int fB = numBottles;
        int eB = 0;
        int ex = numExchange;
        
        int ans = fB;
        eB = fB;
        fB = 0;
        
        while(true){
            
            if(eB < ex){
                break;
            }
            
            fB++;
            eB = eB-ex;
            ex++;
            
            ans += fB;
            eB += fB;
            fB = 0;
        }
        
        return ans;
    }
}
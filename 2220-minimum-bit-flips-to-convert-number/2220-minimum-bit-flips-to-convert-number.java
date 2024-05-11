class Solution {
    public int minBitFlips(int start, int goal) {
        
        int cnt = 0;
        
        for(int i = 31; i >= 0 ; i--){
            
            int x = (start & (1<<i)) == 0 ? 0 : 1;
            int y = (goal & (1<<i)) == 0 ? 0 : 1;
            
            if((x^y) == 1){
                cnt++;
            }
        }
        
        return cnt;
    }
}
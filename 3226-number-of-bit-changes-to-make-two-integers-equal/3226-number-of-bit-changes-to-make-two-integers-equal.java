class Solution {
    public int minChanges(int n, int k) {
        
        if(n == k){
            return 0;
        }
        
        int cnt = 0;
        
        for(int i = 0 ; i < 32 ; i++){
            int x = (n&(1<<i));
            int y = (k&(1<<i));
            
            if(x != y){
                if(x != 0){
                    cnt++;
                }else{
                    return -1;
                }
            }
        }
        
        return cnt;
    }
}
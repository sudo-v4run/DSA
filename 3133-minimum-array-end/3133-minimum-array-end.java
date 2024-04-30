class Solution {
    public long minEnd(int n, int x) {
        
        int xArr[] = new int[64];
        int nArr[] = new int[64];
        
        n--;
        
        for(int i = 31 ; i >= 0 ; i--){
            if((x & (1<<i)) != 0){
                xArr[63-i] = 1;
            }
            
            if((n & (1<<i)) != 0){
                nArr[63-i] = 1;
            }
        }
        
        int i = 63;
        int j = 63;
        
        while(i >= 0){
            if(xArr[i] == 1){
                i--;
                continue;
            }
            xArr[i] = nArr[j];
            i--;
            j--;
        }
        
        long ans = 0;
        
        long pow = 1;
        
        for(int index = 63 ; index  >= 0; index--){
            if(xArr[index] == 0){
                pow = pow*2;
                continue;
            }
            ans += pow;
            pow = pow*2;
        }
        
        return ans;
    }
}
class Solution {
    public int minSwaps(int[] arr) {
        
        int n = arr.length;
        
        int ones = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 1){
                ones++;
            }
        }
        
        int preCnt[] = new int[n];
        
        preCnt[0] = arr[0] == 1 ? 1 : 0;
        for(int i = 1 ; i < n ; i++){
            
            if(arr[i] == 1){
                preCnt[i] = preCnt[i-1] + 1;
            }else{
                preCnt[i] = preCnt[i-1];
            }
        }
        
        if(ones <= 1){
            return 0;
        }
        
        int ans = n;
        
        int l = 0;
        int r = ones-1;
        while(l < n){
            
            int curOnes = 0;
            
            if(l < r%n){
                
                curOnes = preCnt[r];
                if(l > 0){
                    curOnes = preCnt[r]-preCnt[l-1];
                }
            }else{
                
                int newR = r%n;
                curOnes = ones - (preCnt[l-1] - preCnt[newR]);
            }
            
            // or just append the first k elements at the end of the array and keep the
            // first condition only...
            
            int reqSwaps = ones-curOnes;
            
            ans = Math.min(ans,reqSwaps);
            
            l++;
            r++;
        }
        
        return ans;
    }
}
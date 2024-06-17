class Solution {
public:
    int maxTotalReward(vector<int>& arr) {
        
        int n = arr.size();
        
        sort(arr.begin(), arr.end());
        
        bitset<100000> dp,mask,validPrev;
        
        dp[0] = 1;
        
        int maskInd = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            int cur = arr[i];
            
            while(maskInd < cur){
                mask[maskInd] = 1;
                maskInd++;
            }
            
            validPrev = (dp & mask);
            
            dp = dp | (validPrev << cur);
            
        }
        
        for(int i = (int)1e5 ; i >= 0 ; i--){
            if(dp[i] == 1){
                return i;
            }
        }
        
        return 0;
    }
};
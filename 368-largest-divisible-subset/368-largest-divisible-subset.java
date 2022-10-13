class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        
        int maxi = 0;
        int lastInd = 0;
        for(int index = 0 ; index < n ;index++){
            hash[index] = index;
            for(int prev = 0 ; prev < index ; prev++){
                if(nums[index]%nums[prev]==0 && 1+dp[prev] > dp[index]){
                    dp[index] = 1+dp[prev];
                    hash[index] = prev;
                }
            }
            if(maxi<dp[index]){
                maxi = dp[index];
                lastInd = index;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastInd]);
        while(hash[lastInd] != lastInd){
            lastInd = hash[lastInd];
            res.add(nums[lastInd]);
        }
        
        return res;
        
    }
}
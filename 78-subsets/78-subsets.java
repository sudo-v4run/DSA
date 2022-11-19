class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans;
        int n = nums.length;
        
        for(int i = 0 ; i < (1<<n) ; i++){
            ans = new ArrayList<Integer>();
            for(int j = n-1 ; j>=0 ; j--){
                if((i&(1<<j))!=0){
                    ans.add(nums[j]);
                }
            }
            res.add(ans);
        }
        
        return res;
        
    }
}
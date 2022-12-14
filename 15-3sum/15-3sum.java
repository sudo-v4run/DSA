class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(n<3){
            return res;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < n ; i++){
            
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int target = -nums[i];
            int l = i+1;
            int r = n-1;
            
            while(l<r){
                int sum = nums[l]+nums[r];
                
                if(sum<target){
                    l++;
                }else if(sum>target){
                    r--;
                }else{
                    ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    res.add(ans);
                    l++;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        }
        
        return res;
        
    }
}
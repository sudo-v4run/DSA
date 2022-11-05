class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int target = -nums[i];
            
            int l = i+1 ;
            int r = n-1;
            
            while(l<r){
                int sum = nums[l]+nums[r];
                
                if(sum<target){
                    l++;
                }else if(sum>target){
                    r--;
                }else{
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    res.add(ans);
                    ans = new ArrayList<>();
                    
                    while((l+1)<r && nums[l+1]==nums[l])
                        l++;
                    l++;
                }
                
            }
        }
        
        return res;
    }
}
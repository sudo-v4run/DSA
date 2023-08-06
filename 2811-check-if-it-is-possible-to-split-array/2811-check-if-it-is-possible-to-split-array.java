class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        
        boolean ans=false;
        int size=nums.size();
        
        if(size==1|| size == 2)
        {
            return true;
        }
        
        for(int i=0;i<size-1;i++)
        {
            if(nums.get(i)+nums.get(i+1) >= m)
            {
                return true;
            }
        }
        
        return ans;
    }
}
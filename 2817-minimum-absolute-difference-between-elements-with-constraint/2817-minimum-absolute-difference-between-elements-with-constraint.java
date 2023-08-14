class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        
        int n = nums.size();
        
        int arr[] = new int[n];
        int k = 0;
        
        for(int ele : nums){
            arr[k++] = ele;
        }
        
        TreeSet<Integer> ts = new TreeSet<>();
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = x ; i < n ; i++){
            
            ts.add(arr[i-x]);
            Integer up = ts.ceiling(arr[i]);
            Integer lo = ts.floor(arr[i]);
            
            if(up != null){
                ans = Math.min(ans,Math.abs(arr[i]-up));
            }
            if(lo != null){
                ans = Math.min(ans,Math.abs(arr[i]-lo));
            }
        }
        
        return ans;
    }
}
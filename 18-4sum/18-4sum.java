class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums.length<4)
                return res;
        
        int n = nums.length;
        Arrays.sort(nums);
        int k = 4;
        
        kSum(nums,k,target,0,res,ans);
        
        return res;
        

        
        
        
        
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i+1; j < n ; j++){
//                 int tr = target - arr[j]-arr[i];
//                 int left = j+1;
//                 int right = n-1;
//                 while(left<right){
//                     int sum = arr[left]+arr[right];
//                     if(sum<tr){
//                         left++;
//                     }else if(sum>tr){
//                         right--;
//                     }else{
//                         List<Integer> frsum = new ArrayList();
//                         frsum.add(arr[i]);
//                         frsum.add(arr[j]);
//                         frsum.add(arr[left]);
//                         frsum.add(arr[right]);
//                         res.add(frsum);
//                         while(left<right && arr[left]==frsum.get(2)) ++left;
//                         while(left<right && arr[right]==frsum.get(3)) --right;
//                     }
                    
//                 }
//                 while(j+1<n && arr[j+1]==arr[j]) ++j;
//             }
//             while(i+1<n && arr[i+1]==arr[i]) ++i;
//         }
//         return res;
        
    }
    public static void kSum(int nums[],int k,long target,int start,
                            List<List<Integer>> res, ArrayList<Integer> ans){
        
        if(k!=2){
            for(int i = start; i < nums.length-k+1 ; i++){
                if(i>start && nums[i-1]==nums[i])
                    continue;
                ans.add(nums[i]);
                if(target>Integer.MIN_VALUE && target<Integer.MAX_VALUE)
                kSum(nums,k-1,target-nums[i],i+1,res,ans);
                ans.remove(ans.size()-1);
            }
        }else{
            int l = start;
            int r = nums.length-1;

            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum<target){
                    l++;
                }else if(sum>target){
                    r--;
                }else{
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    res.add(new ArrayList<> (ans));
                    ans.remove(ans.size()-1);
                    ans.remove(ans.size()-1);
                    l++;
                    while(l<r && nums[l]==nums[l-1])
                        l++;
                }
            }
        }
        
    }
}
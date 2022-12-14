class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int k = 4;
        
        if(n<k){
            return res;
        }
        
        Arrays.sort(nums);
        
        kSum(nums,k,0,target,res,ans);
        
        return res;
    }
    public static void kSum(int arr[],int k,int start,long target,
                            List<List<Integer>> res, ArrayList<Integer> ans){
        if(k==2){
            int l = start;
            int r = arr.length-1;
            while(l<r){
                int sum = arr[l]+arr[r];
                if(sum<target){
                    l++;
                }else if(sum>target){
                    r--;
                }else{
                    ans.add(arr[l]);
                    ans.add(arr[r]);
                    res.add(new ArrayList<Integer>(ans));
                    ans.remove(ans.size()-1);
                    ans.remove(ans.size()-1);
                    
                    l++;
                    while(l<r && arr[l]==arr[l-1])
                        l++;
                }
            }
        }else{
            for(int i = start ; i < arr.length ; i++){
                if(i>start && arr[i]==arr[i-1])
                    continue;
                
                ans.add(arr[i]);
                kSum(arr,k-1,i+1,target-arr[i],res,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}
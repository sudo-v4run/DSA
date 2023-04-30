class Solution {
    
    static List<List<Integer>> res;
    static ArrayList<Integer> ans;
    static int n;
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        res = new ArrayList<>();
        ans = new ArrayList<>();
        n = nums.length;
        kSum(nums,0,target,4);
        
        return res;
    }
    public void kSum(int arr[],int ind, long target, int k){
        
        if(k == 2){
            int s = ind;
            int e = n-1;
            
            while(s < e){
                int sum = arr[s] + arr[e];
                
                if(sum == target){
                    ans.add(arr[s]);
                    ans.add(arr[e]);
                    if(ans.size() == 4)
                        res.add(new ArrayList<>(ans));
                    ans.remove(ans.size()-1);
                    ans.remove(ans.size()-1);
                    
                    s++;
                    while(s < e && arr[s] == arr[s-1]){
                        s++;
                    }
                }
                
                if(sum < target){
                    s++;
                }else{
                    e--;
                }
            }
            
            return;
        }
        
        for(int i = ind ; i < n ; i++){
            if(i > ind && arr[i] == arr[i-1])
                continue;
            
            ans.add(arr[i]);
            kSum(arr,i+1,target-arr[i],k-1);
            ans.remove(ans.size()-1);
        }
    }
}
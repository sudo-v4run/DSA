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
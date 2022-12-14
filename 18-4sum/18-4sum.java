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
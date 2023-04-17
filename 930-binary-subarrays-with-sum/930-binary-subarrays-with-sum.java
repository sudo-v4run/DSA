class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        
        // TC -> O(N) and SC -> O(1) - Sliding Window...
        
        return atmostK(nums,k) - atmostK(nums,k-1);
        
        
        
        // TC -> O(N) and SC -> O(N) ...
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int cnt = 0;
//         int prefixSum = 0;
        
//         for(int i = 0 ; i < nums.length ; i++){
//             prefixSum += nums[i];
            
//             if(prefixSum == k){
//                 cnt++;
//             }
//             if(hm.containsKey(prefixSum-k)){
//                 cnt += hm.get(prefixSum-k);
//             }
            
//             hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
//         }
        
//         return cnt;
    }
    
    public static int atmostK(int arr[], int k){
        
        int i = 0, j = 0;
        int cnt = 0;
        int n = arr.length;
        int sum = 0;
        
        while(j < n){
            sum += arr[j];
            
            if(sum <= k){
                cnt += j-i+1;
                j++;
            }else if(sum > k){
                while(i <= j && sum > k){
                    sum = sum - arr[i];
                    i++;
                }
                cnt += j-i+1;
                j++;
            }
        }
        
        return cnt;
    }
}
class Solution {
    public int subarraySum(int[] arr, int sum) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int curSum = 0;
        int n = arr.length;
        int cnt = 0;
        hm.put(0,1);
        for(int i = 0 ; i < n ; i++){
            curSum+=arr[i];
            if(hm.containsKey(curSum-sum)){
                cnt+=hm.get(curSum-sum);
            }
            hm.put(curSum,hm.getOrDefault(curSum,0)+1);
        }
        
        return cnt;
        
        
        
        
//         int cnt = 0;
        
//         for(int i = 0 ; i < nums.length ; i++){
//             int sum = nums[i];
//             if(sum==k){
//                 cnt++;
//             }
//             for(int j = i+1 ; j < nums.length ; j++){
//                 sum+=nums[j];
//                 if(sum==k){
//                     cnt++;
//                 }
//             }
//         }
        
//         return cnt;
    }
}
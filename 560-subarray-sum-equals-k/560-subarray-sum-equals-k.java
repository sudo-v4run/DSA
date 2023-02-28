class Solution {
    public int subarraySum(int[] arr, int sum) {
        
        HashMap<Integer,Integer> hm = new HashMap();
        hm.put(0,1);
        
        int ans = 0;
        int prefSum = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            prefSum += arr[i];
            
            if(hm.containsKey(prefSum-sum)){
                ans += hm.get(prefSum-sum);
            }
            hm.put(prefSum,hm.getOrDefault(prefSum,0)+1);
        }
        
        return ans;
        
        
        
        
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
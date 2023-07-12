class Solution {
    public int maxNonDecreasingLength(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        
        int prev1 = 1;
        int prev2 = 1;
        int ans = 1;
        
        // prev1 = length of longest non-decreasing subarray 
        //                             ending at i-1 of arr1
        
        // prev2 = length of longest non-decreasing subarray 
        //                             ending at i-1 of arr2
        
        for(int i = 1 ; i < n ; i++){
            int cur1 = 1;
            int cur2 = 1;
            
            // cur1 = length of longest non-decreasing subarray 
            //                             ending at i of arr1

            // cur2 = length of longest non-decreasing subarray 
            //                              ending at i of arr2
            
            if(arr1[i] >= arr1[i-1]){
                cur1 = Math.max(cur1,prev1+1);
            }
            if(arr1[i] >= arr2[i-1]){
                cur1 = Math.max(cur1,prev2+1);
            }
            if(arr2[i] >= arr1[i-1]){
                cur2 = Math.max(cur2,prev1+1);
            }
            if(arr2[i] >= arr2[i-1]){
                cur2 = Math.max(cur2,prev2+1);
            }
            
            ans = Math.max(ans,Math.max(cur1,cur2));
            prev1 = cur1;
            prev2 = cur2;
        }
        
        return ans;
    }
    
    
//     public int maxNonDecreasingLength(int[] arr1, int[] arr2) {
        
//         int n = arr1.length;
        
//         if(n == 1){
//             return 1;
//         }
        
//         ArrayList<HashMap<Integer, Integer>> dp = new ArrayList<>();
        
//         for(int i = 0 ; i < n ; i++){
//             dp.add(new HashMap<Integer,Integer>());
//         }
        
//         int ans = 0;
//         for(int i = 0 ; i < n ; i++){
//             ans = Math.max(ans,f(i,-1,arr1,arr2,dp));
//         }
        
//         return ans;
//     }
//     public static int f(int index, int prev, int arr1[], int arr2[], 
//                         List<HashMap<Integer, Integer>> dp){
        
//         if(index == arr1.length){
//             return 0;
//         }
        
//         if(arr1[index] < prev && arr2[index] < prev){
//             return 0;
//         }
        
//         if(dp.get(index).containsKey(prev)){
//             return dp.get(index).get(prev);
//         }
        
//         int ans = 0;
        
//         if(arr1[index] >= prev){
//             ans = Math.max(ans,1+f(index+1,arr1[index],arr1,arr2,dp));
//         }
        
//         if(arr2[index] >= prev){
//             ans = Math.max(ans,1+f(index+1,arr2[index],arr1,arr2,dp));
//         }
        
//         dp.get(index).put(prev,ans);
        
//         return ans;
//     }
}
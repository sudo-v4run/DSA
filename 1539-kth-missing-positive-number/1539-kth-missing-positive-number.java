class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;
        
        // Optimal - BS TC-> O(NlogN)...
        
        if(k < arr[0]){
            return k;
        }
        
        int lo = 0;
        int hi = n-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int missing = arr[mid]-(mid+1);
            if(missing < k){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        int more = k-(arr[hi]-(hi+1));
        
        return arr[hi]+more;
        
        
        // Another approach -> TC - O(N) 2 pointers ...
        
//         int i = 1;
//         int j = 0;
//         while(k > 0){
//             if(j < n && i == arr[j]){
//                 i++;
//                 j++;
//             }else{
//                 i++;
//                 k--;
//             }
//         }
        
//         return i-1; // -1 coz k == 0 means i is at (k+1)th missing ele..
//                     // -1 coz we need kth missing, not (k+1)th missing...
//                     // when k == 0, i will be one element ahead...
        
        // TC -> O(N)...
        
        // for(int i = 0 ; i < n ; i++){
        //     if(arr[i] <= k){
        //         k++;
        //     }else{
        //         return k;
        //     }
        // }
        // return k;
    }
}
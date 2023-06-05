class Solution {
    public int semiOrderedPermutation(int[] arr) {
        
        int n = arr.length;
        int iInd = -1;
        int jInd = -1;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 1){
                iInd = i;
            }
            if(arr[i] == n){
                jInd = i;
            }
        }
        
        // 1. Find the ith index of min val 1 => we need to do i operations/swaps
        //    to move 1 to first position.
        
        // 2. Find the ith index of the max val n => we need to do (n - i - 1) 
        //    operations/swaps to take it to last position.
        
        // 3. Take the sum of above two as the answer. Only corner case is 
        //    when the index of 1 is larger than index of n. In this  
        //    case, we need to reduce the ans by 1 coz at one point, they both
        //    will be swaped at once.
        
        int ans = iInd + n-jInd-1;
        
        if(iInd < jInd){
            return ans;
        }
        
        return ans-1;
        
        
        
        
//         int ans = 0;
//         int n = arr.length;
        
//         if(arr[0] != 1){
//             for(int i = n-2 ; i >=0 ; i--){
//                 if(arr[i] > arr[i+1]){
//                     if(arr[i] == 1 || arr[i+1] == 1 || arr[i] == n || arr[i+1] == n){
//                         ans++;
//                     }
//                     swap(arr,i,i+1);
//                 }
//             }
//         }
        
//         if(arr[n-1] == n){
//             return ans;
//         }
        
//         for(int i = 0 ; i < n-1 ; i++){
//             if(arr[i] > arr[i+1]){
//                 if(arr[i] == n || arr[i+1] == n){
//                     ans++;
//                 }
//                 swap(arr,i,i+1);
//             }
//         }
        
//         return ans;
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
class Solution {
    public int maxScore(int[] arr, int k) {
        
        int n = arr.length;
        int i = 0 , j = n-k;
        int total = 0;
        for(int ind = j ; ind < n ; ind++){
            total += arr[ind];
        }
        int max = total;
        
        while(j<n){
            total = total + arr[i] - arr[j];
            max = Math.max(max,total);
            i++;
            j++;
        }
        
        return max;
        
        
        
//         int n = arr.length;
//         int i = 0, j = n-1;
//         int sum = 0;
//         int left = 0;
//         int right = 0;
        
//         for(int ind = 0 ; ind < k ; ind++){
//             left += arr[ind];
//         }
        
//         for(int ind = n-1 ; ind >= n-k ; ind--){
//             right += arr[ind];
//         }
        
//         while(i <= j){
//             if(k == 0){
//                 break;
//             }
            
//             if(left > right){
//                 sum += arr[i];
//                 left = left - arr[i];
//                 right = right - arr[j-k+1];
//                 i++;
//             }else{
//                 sum += arr[j];
//                 right = right - arr[j];
//                 left = left - arr[i+k-1];
//                 j--;
//             }
//             k--;
//         }
        
//         return sum;
    }
}
class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        
        int cnt = 0;
        
        for(int i = 1 ; i < n ; i++){
            if(arr[i]==arr[i-1]){
                cnt++;
            }else{
                arr[i-cnt] = arr[i];
            }
        }
        
        return n-cnt;
        
        
        
//         int i = 0;
//         int j = 1;
//         int k = 1;
        
//         while(j<n){
//             if(arr[i]!=arr[j]){
//                 arr[i+1] = arr[j];
//                 i++;j++;
//                 k++;
//             }else{
//                 j++;
//             }
//         }
        
//         return k;
    }
}
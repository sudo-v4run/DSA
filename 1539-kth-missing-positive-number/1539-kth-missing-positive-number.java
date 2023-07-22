class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;
        
        
        // Another approach -> TC - O(N) 2 pointers ...
        
        int i = 1;
        int j = 0;
        while(k > 0){
            if(j < n && i == arr[j]){
                i++;
                j++;
            }else{
                i++;
                k--;
            }
        }
        
        return i-1;
        
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
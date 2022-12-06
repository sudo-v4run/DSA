class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    // Avg - O(n) .. worst - O(n^2)....
        
        k = nums.length - k;
        
        return quickSelect(0,nums.length-1,nums,k);
        
        
   
    // TC - O(klogn)...
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         for(int i = 0 ; i < k ; i++){
//             pq.add(nums[i]);
//         }
        
//         for(int i = k ; i < nums.length ; i++){
//             if(nums[i]>pq.peek()){
//                 pq.poll();
//                 pq.add(nums[i]);
//             }
//         }
        
//         return pq.peek();
        
    }
    public static int quickSelect(int l , int r ,int arr[], int k){
        int pivot = arr[r];
        int p = l;
        for(int i = l ; i < r ; i++){
            if(arr[i]<=pivot){
                swap(arr,i,p);
                p++;
            }
        }
        swap(arr,p,r);
        if(k>p){
            return quickSelect(p+1,r,arr,k);
        }else if(k<p){
            return quickSelect(l,p-1,arr,k);
        }else{
            return arr[p];
        }
    }
    public static void swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
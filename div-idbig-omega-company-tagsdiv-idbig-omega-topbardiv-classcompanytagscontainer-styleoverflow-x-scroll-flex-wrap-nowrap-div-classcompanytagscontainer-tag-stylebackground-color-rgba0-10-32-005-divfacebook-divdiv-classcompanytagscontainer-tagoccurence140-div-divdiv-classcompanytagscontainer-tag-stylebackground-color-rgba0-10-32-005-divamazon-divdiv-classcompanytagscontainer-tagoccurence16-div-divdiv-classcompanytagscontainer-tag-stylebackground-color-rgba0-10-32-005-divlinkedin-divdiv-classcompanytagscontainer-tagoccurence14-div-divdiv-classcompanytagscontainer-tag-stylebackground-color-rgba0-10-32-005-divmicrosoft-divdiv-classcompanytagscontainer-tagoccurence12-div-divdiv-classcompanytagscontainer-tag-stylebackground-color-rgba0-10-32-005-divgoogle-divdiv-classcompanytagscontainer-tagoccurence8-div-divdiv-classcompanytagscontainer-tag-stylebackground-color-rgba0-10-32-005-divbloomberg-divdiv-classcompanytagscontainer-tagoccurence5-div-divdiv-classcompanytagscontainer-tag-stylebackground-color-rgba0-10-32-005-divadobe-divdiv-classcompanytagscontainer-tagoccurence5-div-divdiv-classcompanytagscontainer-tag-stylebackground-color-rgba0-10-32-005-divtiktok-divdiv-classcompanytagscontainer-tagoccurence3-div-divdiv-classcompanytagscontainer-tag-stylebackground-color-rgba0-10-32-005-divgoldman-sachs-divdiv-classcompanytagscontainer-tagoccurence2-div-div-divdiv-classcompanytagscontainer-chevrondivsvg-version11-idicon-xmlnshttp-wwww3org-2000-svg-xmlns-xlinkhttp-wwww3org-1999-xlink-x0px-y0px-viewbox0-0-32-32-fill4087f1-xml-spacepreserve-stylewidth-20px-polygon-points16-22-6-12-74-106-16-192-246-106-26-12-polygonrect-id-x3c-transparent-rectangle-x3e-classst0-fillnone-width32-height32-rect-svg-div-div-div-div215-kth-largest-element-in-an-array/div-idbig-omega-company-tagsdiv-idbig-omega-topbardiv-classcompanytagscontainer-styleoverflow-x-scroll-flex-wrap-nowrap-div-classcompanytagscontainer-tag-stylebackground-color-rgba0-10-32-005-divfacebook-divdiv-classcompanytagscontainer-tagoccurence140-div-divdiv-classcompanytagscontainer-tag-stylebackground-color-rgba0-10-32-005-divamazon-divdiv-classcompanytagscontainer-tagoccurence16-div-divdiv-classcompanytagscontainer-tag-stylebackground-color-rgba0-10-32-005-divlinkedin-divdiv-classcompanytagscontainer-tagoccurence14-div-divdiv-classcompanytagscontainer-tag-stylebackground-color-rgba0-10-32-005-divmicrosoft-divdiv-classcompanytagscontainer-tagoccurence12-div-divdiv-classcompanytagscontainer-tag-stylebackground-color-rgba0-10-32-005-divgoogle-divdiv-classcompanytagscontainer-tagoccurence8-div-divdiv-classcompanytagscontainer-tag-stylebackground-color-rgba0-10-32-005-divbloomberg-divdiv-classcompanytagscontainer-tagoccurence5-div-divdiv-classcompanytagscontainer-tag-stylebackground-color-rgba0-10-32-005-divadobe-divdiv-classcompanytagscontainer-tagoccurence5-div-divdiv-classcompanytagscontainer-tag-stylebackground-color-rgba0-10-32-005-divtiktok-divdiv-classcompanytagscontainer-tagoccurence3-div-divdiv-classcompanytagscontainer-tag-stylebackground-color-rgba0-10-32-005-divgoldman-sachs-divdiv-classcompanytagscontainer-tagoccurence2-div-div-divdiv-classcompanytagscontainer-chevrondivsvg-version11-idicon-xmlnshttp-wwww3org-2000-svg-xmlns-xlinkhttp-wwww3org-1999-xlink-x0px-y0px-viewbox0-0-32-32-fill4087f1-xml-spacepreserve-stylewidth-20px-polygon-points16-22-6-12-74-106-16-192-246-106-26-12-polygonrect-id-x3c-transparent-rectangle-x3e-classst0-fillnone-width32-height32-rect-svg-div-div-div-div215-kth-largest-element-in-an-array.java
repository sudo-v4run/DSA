class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    // Avg - O(n) .. worst - O(n^2)....
        
//         int reqInd = nums.length - k;
        
//         return quickSelect(0,nums.length-1,reqInd,nums);
        
   
    // TC - O(nlogk)...
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < k ; i++){
            pq.add(nums[i]);
        }
        
        for(int i = k ; i < nums.length ; i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
    public static int quickSelect(int l, int h, int reqInd, int arr[]){
        
        if(l <= h){
            int pivot = partition(l,h,arr);
            if(pivot == reqInd){
                return arr[pivot];
            }else if(pivot > reqInd){
                return quickSelect(l,pivot-1,reqInd,arr);
            }else{
                return quickSelect(pivot+1,h,reqInd,arr);
            }
        }
        
        return -1;
    }
    public static int partition(int l, int h, int arr[]){
        int pivot = arr[l];
        int i = l;
        int j = h;
        
        while(i < j){
            while(i <= h && arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            
            if(i < j){
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        
        return j;
    }
    public static void swap(int arr[], int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
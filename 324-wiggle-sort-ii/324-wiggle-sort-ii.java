class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int arr[] = new int[n];
        int i = 1;
        int j = n-1;
        
        while(i<n){
            arr[i] = nums[j];
            j--;
            i = i+2;
        }
        
        i=0;
        
        while(i<n){
            arr[i] = nums[j];
            i = i+2;
            j--;
        }
        
        for(int k = 0 ; k < n ; k++){
            nums[k] = arr[k];
        }
    }
}
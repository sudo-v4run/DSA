class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int j = 0;
        
        // for(int i = 0 ; i < nums.length; i++){
        //     if(nums[i]!=0){
        //         swap(nums,i,j);
        //         j++;
        //     }
        // }
        
        for(int ele : nums){
            if(ele != 0){
                nums[j++] = ele;
            }
        }
        
        while(j < n){
            nums[j++] = 0;
        }
    }
    public static void swap(int arr[] ,int i , int j){
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
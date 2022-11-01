class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        
        int h = 0;
        int i = 1;
        
        while(h < n && i < n){
            if(h<n && nums[h]!=0){
                h++;
            }else if(h<n && nums[i]!=0){
                swap(nums,i,h);
                h++;
            }
            i++;
        }
        
    }
    public static void swap(int arr[] ,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
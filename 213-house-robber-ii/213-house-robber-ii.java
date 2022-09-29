class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n==1)
            return nums[0];
        
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];
        int k=0 , l=0;
        for(int i = 0 ; i < n ; i++){
            if(i!=0){
                temp1[k++] = nums[i]; 
            }
            if(i!=(n-1)){
                temp2[l++] = nums[i];
            }
        }
        
        return Math.max(hr(temp1),hr(temp2));
    }
    public int hr(int arr[]){
        int prev1 = arr[0];
        int prev2 = 0;
        
        for(int i = 1 ; i < arr.length ; i++){
            int takeThis = arr[i];
            if(i>1)
                takeThis += prev2;
            
            int notTake = 0 + prev1;
            
            int curi = Math.max(takeThis,notTake);
            
            prev2 = prev1;
            prev1 = curi;
        }
        
        return prev1;
    }
}
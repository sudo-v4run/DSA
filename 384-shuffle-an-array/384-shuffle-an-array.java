class Solution {
    
    int ori[];
    int n;

    public Solution(int[] nums) {
        ori = nums;
        n = nums.length;
    }
    
    public int[] reset() {
        return ori;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        
        int shfl[] = ori.clone();
        
        for(int i = n-1 ; i >=0 ; i--){
            int randInt = rand.nextInt(i+1);
            swap(shfl,i,randInt);
        }
        
        return shfl;
    }
    public static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
class Solution {
    public int maxSubArray(int[] arr) {
        int curSum=0;
        int maxSum = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            curSum+=arr[i];
            if(maxSum<curSum)
                maxSum=curSum;
            if(curSum<=0)
                curSum=0;
        }
        
        return maxSum;
    }
}
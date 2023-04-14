class Solution {
    public int longestOnes(int[] arr, int k) {
        
        int i = 0, j = 0;
        int n = arr.length;
        int max = 0;
        
        while(j < n){
            if(arr[j] == 0){
                k--;
            }
            if(k >= 0){
                max = Math.max(max,j-i+1);
                j++;
            }else if(k < 0){
                while(k < 0){
                    if(arr[i] == 0){
                        k++;
                    }
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}
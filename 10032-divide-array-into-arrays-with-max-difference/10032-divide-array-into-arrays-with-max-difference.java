class Solution {
    public int[][] divideArray(int[] arr, int k) {
     
        int n = arr.length;

        int res[][] = new int[n/3][3];
        int r = 0;
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n ; i = i+3){
            int c = 0;
            if(Math.abs(arr[i]-arr[i+2]) > k){
                return new int[][]{};
            }
            for(int j = i ; j < i+3 ; j++){
                res[r][c] = arr[j];
                c++;
            }
            r++;
        }
        
        
        return res;
    }
}
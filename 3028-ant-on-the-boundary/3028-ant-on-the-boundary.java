class Solution {
    public int returnToBoundaryCount(int[] arr) {
        
        int n = arr.length;
        int sum = 0;
        int cnt = 0;
        
        for(int ele : arr){
            sum += ele;
            if(sum == 0){
                cnt++;
            }
        }
        
        return cnt;
    }
}
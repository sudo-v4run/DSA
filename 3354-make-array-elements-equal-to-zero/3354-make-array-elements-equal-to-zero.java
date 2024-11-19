class Solution {
    public int countValidSelections(int[] arr) {
        
        int n = arr.length;
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            if(arr[i] != 0){
                continue;
            }
            
            int leftSum = 0;
            int rightSum = 0;
            
            for(int j = i-1 ; j >= 0 ; j--){
                leftSum += arr[j];
            }
            for(int j = i+1 ; j < n ; j++){
                rightSum += arr[j];
            }
            
            if(leftSum == rightSum){
                cnt += 2;
            }else if(leftSum == rightSum+1){
                cnt++;
            }else if(rightSum == leftSum+1){
                cnt++;
            }
        }
        
        return cnt;
    }
}
class Solution {
    public boolean canSplitArray(List<Integer> arr, int m) {
        
        int n = arr.size();
        
        if(n <= 2){
            return true;
        }
        
        for(int i = 0 ; i < n-1 ; i++){
            if(arr.get(i)+arr.get(i+1) >= m){
                return true;
            }
        }
        
        return false;
    }
}
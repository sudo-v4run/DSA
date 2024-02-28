class Solution {
    public boolean isPossibleToSplit(int[] arr) {
        
        int n = arr.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0; i < n ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            if(hm.get(arr[i]) > 2){
                return false;
            }
        }
        
        return true;
    }
}
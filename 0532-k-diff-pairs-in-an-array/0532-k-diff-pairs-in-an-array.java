class Solution {
    public int findPairs(int[] arr, int k) {
     
        int n = arr.length;
        
        HashSet<String> hs = new HashSet<>();
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(Math.abs(arr[i] - arr[j]) == k && 
                   !hs.contains(arr[i]+","+arr[j]) && !hs.contains(arr[j]+","+arr[i])){
                    
                    cnt++;
                    hs.add(arr[i]+","+arr[j]);
                    hs.add(arr[j]+","+arr[i]);
                }
            }
        }
        
        return cnt;
    }
}
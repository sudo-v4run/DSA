class Solution {
    public int sumImbalanceNumbers(int[] arr) {
        
        int n = arr.length;
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> hs = new HashSet<>();
            int cnt = 0;
            hs.add(arr[i]);
            for(int j = i+1 ; j < n ; j++){
                if(!hs.contains(arr[j])){
                    int d = 1;
                    if(hs.contains(arr[j]-1)) d--;
                    if(hs.contains(arr[j]+1)) d--;
                    cnt += d;
                }
                ans += cnt;
                hs.add(arr[j]);
            }
        }
        
        return ans;
    }
}
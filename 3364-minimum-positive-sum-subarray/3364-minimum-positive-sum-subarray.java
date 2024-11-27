class Solution {
    public int minimumSumSubarray(List<Integer> arr, int l, int r) {
        
        int n = arr.size();
        int ans = Integer.MAX_VALUE;
        
        for(int len = l ; len <= r; len++){
            int cur = f(arr,len);
            if(cur != Integer.MAX_VALUE){
                ans = Math.min(ans,cur);
            }
        }
        
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
    public int f(List<Integer> arr, int len){
        
        int n = arr.size();
        int min = Integer.MAX_VALUE;
        
        int s = 0;
        
        for(int i = 0 ; i < n && i < len ; i++){
            s += arr.get(i);
        }
        
        int i = 0;
        int j = i+len;
        
        if(s > 0){
            min = Math.min(min,s);
        }
        
        while(j < n){
            s -= arr.get(i);
            s += arr.get(j);
            if(s > 0){
                min = Math.min(min,s);
            }
            i++;
            j++;
        }
        
        return min;
    }
}
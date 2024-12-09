class Solution {
    public int getLargestOutlier(int[] arr) {
        
        int n = arr.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        
        for(int x : arr){
            sum += x;
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        int ans = -10000;
        
        for(int i = 0 ; i < n ; i++){
            
            int rem = sum - arr[i];
            hm.put(arr[i],hm.get(arr[i])-1);
            
            if(rem%2 != 0){
                
                hm.put(arr[i],hm.get(arr[i])+1);
                continue;
            }
            
            if(hm.containsKey(rem/2) && hm.get(rem/2) >= 1){
                ans = Math.max(ans,arr[i]);
            }
            
            hm.put(arr[i],hm.get(arr[i])+1);
        }
        
        return ans;
    }
}
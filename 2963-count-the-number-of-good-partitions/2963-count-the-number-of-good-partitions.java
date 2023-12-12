class Solution {
    public int numberOfGoodPartitions(int[] arr) {
        
        int mod = (int)1e9+7;
        
        int n = arr.length;
        
        HashMap<Integer,Integer> lastOccurenceMap = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            lastOccurenceMap.put(arr[i],i);
        }
        
        int grps = 0;
        
        int i = 0, j = 0;
        
        while(i < n){
            if(i > j){
                grps++;
            }
            j = Math.max(j,lastOccurenceMap.get(arr[i]));
            i++;
        }
        grps++;
        
        // res = 2^(grps-1) .i.e 2 power grps-1
        
        int res = 1;
        for(int k = 0 ; k < grps-1 ; k++){        
            res = (res*2)%mod;
        }
        
        return res;
    }
}
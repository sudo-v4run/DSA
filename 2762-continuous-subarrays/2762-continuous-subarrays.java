class Solution {
    public long continuousSubarrays(int[] arr) {
        
        int n = arr.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        
        long cnt = 0;
        int i = 0;
        int j = 0;
        
        while(j < n){
            
            tm.put(arr[j],tm.getOrDefault(arr[j],0)+1);
            
            if(tm.lastKey() - tm.firstKey() <= 2){
                cnt += (j-i+1);
                j++;
            }else{
                while(tm.lastKey() - tm.firstKey() > 2){
                    tm.put(arr[i],tm.get(arr[i])-1);
                    if(tm.get(arr[i]) == 0){
                        tm.remove(arr[i]);
                    }
                    i++;
                }
                cnt += (j-i+1);
                j++;
            }
        }
        
        return cnt;
    }
}
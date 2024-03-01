class Solution {
    public int findPairs(int[] arr, int k) {
        
        int n = arr.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(hm.containsKey(arr[i])){
                if(k == 0 && hm.get(arr[i])==1){
                    cnt++;
                }
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                if(hm.containsKey(arr[i]-k)){
                    cnt++;
                }
                if(hm.containsKey(arr[i]+k)){
                    cnt++;
                }
                hm.put(arr[i],1);
            }
        }
        
        return cnt;
    }
}
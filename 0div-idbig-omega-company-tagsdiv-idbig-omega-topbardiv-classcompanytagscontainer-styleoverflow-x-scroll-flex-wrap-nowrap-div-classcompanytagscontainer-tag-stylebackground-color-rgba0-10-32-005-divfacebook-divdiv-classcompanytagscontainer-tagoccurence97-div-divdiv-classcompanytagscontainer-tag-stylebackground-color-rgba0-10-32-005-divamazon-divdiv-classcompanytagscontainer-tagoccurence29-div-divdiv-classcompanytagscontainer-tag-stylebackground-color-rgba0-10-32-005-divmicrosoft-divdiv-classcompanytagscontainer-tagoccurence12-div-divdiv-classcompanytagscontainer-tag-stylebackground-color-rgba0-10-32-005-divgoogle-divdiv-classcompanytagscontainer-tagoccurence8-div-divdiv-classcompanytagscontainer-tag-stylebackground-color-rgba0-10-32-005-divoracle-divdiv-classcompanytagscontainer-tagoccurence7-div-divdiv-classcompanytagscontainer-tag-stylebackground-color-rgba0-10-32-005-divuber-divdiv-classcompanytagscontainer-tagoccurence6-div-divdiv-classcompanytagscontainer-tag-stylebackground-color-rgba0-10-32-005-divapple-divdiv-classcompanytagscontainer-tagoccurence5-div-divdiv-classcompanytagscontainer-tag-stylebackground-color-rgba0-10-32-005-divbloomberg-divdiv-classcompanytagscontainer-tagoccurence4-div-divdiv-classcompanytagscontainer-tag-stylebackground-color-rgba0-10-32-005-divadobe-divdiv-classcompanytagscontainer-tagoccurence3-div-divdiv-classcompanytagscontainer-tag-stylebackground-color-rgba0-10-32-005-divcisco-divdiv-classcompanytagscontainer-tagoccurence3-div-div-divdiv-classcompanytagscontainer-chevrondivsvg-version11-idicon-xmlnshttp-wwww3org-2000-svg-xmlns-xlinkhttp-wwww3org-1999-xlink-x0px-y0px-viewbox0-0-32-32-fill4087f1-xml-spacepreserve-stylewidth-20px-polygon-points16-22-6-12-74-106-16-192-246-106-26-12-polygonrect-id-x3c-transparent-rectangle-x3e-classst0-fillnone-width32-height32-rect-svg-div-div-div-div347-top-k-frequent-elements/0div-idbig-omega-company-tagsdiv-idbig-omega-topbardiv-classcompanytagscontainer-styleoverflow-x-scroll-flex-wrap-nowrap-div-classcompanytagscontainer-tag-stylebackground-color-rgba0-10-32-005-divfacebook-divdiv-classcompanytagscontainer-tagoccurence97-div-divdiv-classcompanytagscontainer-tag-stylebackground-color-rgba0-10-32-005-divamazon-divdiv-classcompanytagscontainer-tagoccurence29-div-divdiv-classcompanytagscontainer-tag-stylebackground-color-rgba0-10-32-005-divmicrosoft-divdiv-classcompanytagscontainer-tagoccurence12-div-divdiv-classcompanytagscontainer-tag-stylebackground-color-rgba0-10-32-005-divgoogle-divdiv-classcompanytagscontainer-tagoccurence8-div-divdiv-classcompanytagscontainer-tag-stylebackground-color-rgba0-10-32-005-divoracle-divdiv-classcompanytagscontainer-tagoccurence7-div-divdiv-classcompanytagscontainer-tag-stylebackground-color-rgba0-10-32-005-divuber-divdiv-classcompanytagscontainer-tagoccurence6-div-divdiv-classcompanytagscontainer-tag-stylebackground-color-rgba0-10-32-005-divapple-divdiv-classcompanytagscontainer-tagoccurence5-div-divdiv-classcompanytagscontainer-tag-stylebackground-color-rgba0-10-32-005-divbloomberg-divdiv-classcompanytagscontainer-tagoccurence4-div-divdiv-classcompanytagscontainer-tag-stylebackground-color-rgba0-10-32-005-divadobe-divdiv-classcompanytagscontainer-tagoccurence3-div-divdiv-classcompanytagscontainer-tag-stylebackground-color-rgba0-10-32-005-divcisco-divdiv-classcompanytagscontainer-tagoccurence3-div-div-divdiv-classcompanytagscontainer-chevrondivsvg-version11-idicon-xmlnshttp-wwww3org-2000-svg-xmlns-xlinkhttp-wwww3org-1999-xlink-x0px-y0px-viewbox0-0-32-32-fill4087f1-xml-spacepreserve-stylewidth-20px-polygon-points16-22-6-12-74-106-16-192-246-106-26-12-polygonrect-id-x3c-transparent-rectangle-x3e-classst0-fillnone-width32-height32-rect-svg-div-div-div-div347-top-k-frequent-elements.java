class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        
        int n = arr.length;
        
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer>[] count = new ArrayList[n+1];
        
        for(int i = 0 ; i < n ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        for(int key : hm.keySet()){
            int ele = key;
            int freq = hm.get(key);
            
            if(count[freq] == null){
                count[freq] = new ArrayList<>();
            }
            count[freq].add(ele);
        }
        
        int res[] = new int[k];
        int j = 0;
        
        for(int i = n ; i >=0 ; i--){
            if(count[i] == null){
                continue;
            }
            for(int ele : count[i]){
                res[j++] = ele;
                if(j == k){
                    return res;
                }
            }
        }
        
        return res;
    }
}
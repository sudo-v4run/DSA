class Solution {
    public long[] mostFrequentIDs(int[] arr, int[] freq){
        
        int n = arr.length;
        
        long ans[] = new long[n];
        
        // TreeMap<Long,HashSet<Integer>> tm = new TreeMap<>();
        TreeMap<Long,Integer> tm = new TreeMap<>();
        HashMap<Integer,Long> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            
            int val = arr[i];
            long f = hm.getOrDefault(val,0l);
            
            if(tm.containsKey(f)){
                
                // tm.get(f).remove(val);
                // if(tm.get(f).size() == 0){
                //     tm.remove(f);
                // }
                
                tm.put(f,tm.get(f)-1);
                if(tm.get(f) == 0){
                    tm.remove(f);
                }
            }
            
            hm.put(val,hm.getOrDefault(val,0l)+freq[i]);
            
            long newFreq = hm.get(val);
            
            // if(!tm.containsKey(newFreq)){
            //     tm.put(newFreq,new HashSet<>());
            // }
            // tm.get(newFreq).add(val);
            
            tm.put(newFreq,tm.getOrDefault(newFreq,0)+1);
            
            ans[i] = tm.lastKey();
        }
        
        return ans;
    }
    
    
    
//     public long[] mostFrequentIDs(int[] arr, int[] freq) {
        
//         int n = arr.length;
        
//         long ans[] = new long[n];
        
//         PriorityQueue<Pair> pq = 
//             new PriorityQueue<>((a,b)->{return (int)b.f-(int)a.f;});
//         HashMap<Integer,Long> hm = new HashMap<>();
        
//         for(int i = 0 ; i < n ; i++){
//             int val = arr[i];
//             hm.put(val,hm.getOrDefault(val,0l)+freq[i]);
//             pq.add(new Pair(hm.get(val),val));
            
//             while(!pq.isEmpty()){
//                 Pair pop = pq.peek();
//                 if(hm.get(pop.val) != pop.f){
//                     pq.poll();
//                 }else{
//                     break;
//                 }
//             }
            
//             ans[i] = pq.peek().f;
//         }
        
//         return ans;
//     }
//     class Pair{
//         long f;
//         int val;
//         Pair(long f, int val){
//             this.f = f;
//             this.val = val;
//         }
//     }
}
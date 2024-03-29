class Solution {
    public long[] mostFrequentIDs(int[] arr, int[] freq) {
        
        int n = arr.length;
        
        long ans[] = new long[n];
        
        PriorityQueue<Pair> pq = 
            new PriorityQueue<>((a,b)->{return (int)b.f-(int)a.f;});
        HashMap<Integer,Long> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            int val = arr[i];
            hm.put(val,hm.getOrDefault(val,0l)+freq[i]);
            pq.add(new Pair(hm.get(val),val));
            
            while(!pq.isEmpty()){
                Pair pop = pq.peek();
                if(hm.get(pop.val) != pop.f){
                    pq.poll();
                }else{
                    break;
                }
            }
            
            ans[i] = pq.peek().f;
        }
        
        return ans;
    }
    class Pair{
        long f;
        int val;
        Pair(long f, int val){
            this.f = f;
            this.val = val;
        }
    }
}
class Solution {
    class Pair{
        String s;
        int f;
        Pair(String s, int f){
            this.s = s;
            this.f = f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String word : words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.f == b.f){
                return b.s.compareTo(a.s);
            }else{
                return a.f - b.f;
            }
        });
        
        for(String s : hm.keySet()){
            pq.add(new Pair(s,hm.get(s)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> res = new ArrayList<>();
        
        while(!pq.isEmpty()){
            res.add(0,pq.poll().s);
        }
        
        return res;
    }
}
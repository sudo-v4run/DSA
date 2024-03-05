class Solution {
    
    // TC -> O(N) in the best case and O(NlongN) in the worst case...
    
    public List<String> topKFrequent(String[] words, int k){
        
        int n = words.length;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String w : words){
            hm.put(w,hm.getOrDefault(w,0)+1);
        }
        
        TreeSet<String>[] count = new TreeSet[n+1];
        
        for(String s : hm.keySet()){
            
            int f = hm.get(s);
            
            if(count[f] == null){
                count[f] = new TreeSet<String>();
            }
            
            count[f].add(s);
        }
        
        List<String> res = new ArrayList<>();
        int j = 0;
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(count[i] == null){
                continue;
            }
            
            for(String s : count[i]){
                res.add(s);
                j++;
                if(j == k){
                    return res;
                }
            }
        }
        
        return res;
    }
    
    
    // TC -> O(NLogK)...
    
//     class Pair{
//         String s;
//         int f;
//         Pair(String s, int f){
//             this.s = s;
//             this.f = f;
//         }
//     }
//     public List<String> topKFrequent(String[] words, int k) {
        
//         HashMap<String,Integer> hm = new HashMap<>();
        
//         for(String word : words){
//             hm.put(word,hm.getOrDefault(word,0)+1);
//         }
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
//             if(a.f == b.f){
//                 return b.s.compareTo(a.s);
//             }else{
//                 return a.f - b.f;
//             }
//         });
        
//         for(String s : hm.keySet()){
//             pq.add(new Pair(s,hm.get(s)));
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
        
//         List<String> res = new ArrayList<>();
        
//         while(!pq.isEmpty()){
//             res.add(0,pq.poll().s);
//         }
        
//         return res;
//     }
}
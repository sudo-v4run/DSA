class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        
        int n = word.length();
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        int i = 0;
        int j = k-1;
        
        while(i < n){
            
            String s = word.substring(i,j+1);
            
            hm.put(s,hm.getOrDefault(s,0)+1);
            
            i = i+k;
            j = i+k-1;
            
        }
        
        ArrayList<Pair> arr = new ArrayList<>();
        for(String s : hm.keySet()){
            
            int freq = hm.get(s);
            
            arr.add(new Pair(s,freq));
        }
        
        Collections.sort(arr,(a,b)->{return b.f - a.f;});
        
        return (n/k)-arr.get(0).f;
    }
    class Pair{
        String s;
        int f;
        Pair(String s, int f){
            this.s = s;
            this.f = f;
        }
    }
}
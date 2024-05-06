class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        
        int n = word.length();
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        int i = 0;
        int j = k-1;
        
        int maxF = -1;
        
        while(i < n){
            
            String s = word.substring(i,j+1);
            
            hm.put(s,hm.getOrDefault(s,0)+1);
            maxF = Math.max(maxF,hm.get(s));
            
            i = i+k;
            j = i+k-1;
            
        }
        
        return (n/k)-maxF;
    }
}
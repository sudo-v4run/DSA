class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        
        int n = s.length();
        int len = n/k;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i = i+len){
            
            String temp = s.substring(i,i+len);
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }
        
        for(int i = 0 ; i < n ; i = i+len){
            
            String temp = t.substring(i,i+len);
            
            if(!hm.containsKey(temp) || hm.get(temp) <= 0){
                return false;
            }else{
                hm.put(temp,hm.get(temp)-1);
            }
        }
        
        return true;
    }
}
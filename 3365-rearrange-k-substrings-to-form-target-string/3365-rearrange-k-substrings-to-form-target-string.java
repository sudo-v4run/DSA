class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        
        int n = s.length();
        int len = n/k;
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i = i+len){
            String temp = "";
            for(int j = i ; j < i+len ; j++){
                temp += s.charAt(j);
            }
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }
        
        for(int i = 0 ; i < n ; i = i+len){
            String temp = "";
            for(int j = i ; j < i+len ; j++){
                temp += t.charAt(j);
            }
            if(!hm.containsKey(temp) || hm.get(temp) <= 0){
                return false;
            }else{
                hm.put(temp,hm.get(temp)-1);
            }
        }
        
        return true;
    }
}
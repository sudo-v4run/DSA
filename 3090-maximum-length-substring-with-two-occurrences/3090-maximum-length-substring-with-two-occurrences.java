class Solution {
    public int maximumLengthSubstring(String s) {
        
        int n = s.length();
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            String temp = "";
            for(int j = i; j < n ; j++){
                temp += s.charAt(j);
                HashMap<Character,Integer> hm = new HashMap<>();
                boolean isPoss = true;
                for(int k = 0 ; k < temp.length() ; k++){
                    char ch = temp.charAt(k);
                    hm.put(ch,hm.getOrDefault(ch,0)+1);
                    if(hm.get(ch) > 2){
                        isPoss = false;
                        break;
                    }
                }
                
                if(isPoss){
                    ans = Math.max(ans,temp.length());
                }
            }
        }
        
        return ans;
    }
}
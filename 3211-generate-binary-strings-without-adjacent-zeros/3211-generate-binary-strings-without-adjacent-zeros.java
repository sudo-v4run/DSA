class Solution {
    public List<String> validStrings(int n) {
        
        List<String> res = new ArrayList<>();
        
        for(int i = 0 ; i < (1 << n); i++){
            
            String cur = Integer.toBinaryString(i);
            int len = cur.length();
            
            for(int j = 0 ; j < n-len ; j++){
                cur = '0'+cur;
            }
            
            boolean flag = true;
            
            for(int j = 1 ; j < cur.length() ; j++){
                if(cur.charAt(j) != '1' && cur.charAt(j-1) != '1'){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                res.add(cur);
            }
        }
        
        return res;
    }
}
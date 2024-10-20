class Solution {
    public List<String> stringSequence(String target) {
        
        int n = target.length();
        
        List<String> res = new ArrayList<>();
        
        String temp = "";
        for(int i = 0 ; i < n ; i++){
            temp += 'a';
            char tarr[] = temp.toCharArray();
            res.add(String.valueOf(tarr));
            while(tarr[i] != target.charAt(i)){
                if(tarr[i] == 'z'){
                    tarr[i] = 'a';
                }else{
                    tarr[i]++;
                }
                
                res.add(String.valueOf(tarr));
            }
            temp = String.valueOf(tarr);
        }
        
        return res;
    }
}
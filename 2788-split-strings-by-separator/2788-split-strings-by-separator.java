class Solution {
    public List<String> splitWordsBySeparator(List<String> words, 
                                              char separator){
        
        String str = "";
        
        for(String s : words){
            str += s+separator;
        }
        
        List<String> res = new ArrayList<>();
        
        String temp = "";
        
        for(int i = 0 ; i < str.length() ; i++){
            
            if(str.charAt(i) == separator){
                if(!temp.equals("")){
                    res.add(temp);
                }
                temp = "";
            }else{
                temp += str.charAt(i);
            }
        }
        
        return res;
    }
}
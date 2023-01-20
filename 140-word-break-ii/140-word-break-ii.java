class Solution {
    
    static List<String> res;
    
    Solution(){
        res = new ArrayList<>();
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> hs = new HashSet();
        
        for(String word : wordDict){
            hs.add(word);
        }
        
        String ans = "";

        f(s,0,ans,hs);
        
        return res;
    }
    
    public static void f(String s, int index,String ans, Set<String> hs){
        
        if(index >= s.length()){
            res.add(ans.substring(0,ans.length()-1));
        }
        
        for(int i = index ; i < s.length() ; i++){
            String temp = s.substring(index,i+1);
            if(hs.contains(temp)){
                f(s,i+1,ans+temp+" ",hs);
            }
        }
    }
}
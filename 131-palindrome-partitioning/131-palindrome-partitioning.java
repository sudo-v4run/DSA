class Solution {
    
    static List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        
        res = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        f(0,s,ans);
        
        return res;
    }
    public static void f(int index, String s, ArrayList<String> ans){
        
        if(index == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i = index ; i < s.length() ; i++){
            
            String curSubStr = s.substring(index,i+1);
            if(isPali(curSubStr)){
                ans.add(curSubStr);
                f(i+1,s,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static boolean isPali(String str){
        int s = 0;
        int e = str.length()-1;
        
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        
        return true;
    }
}
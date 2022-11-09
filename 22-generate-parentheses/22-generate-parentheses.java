class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        f("",n,n,res);
        
        return res;
    }
    public static void f(String ans,int open, int close, List<String> res){
        
        if(open==0 && close==0){
            res.add(ans);
            return;
        }
        
        if(close<open || open<0 || close<0){
            return;
        }
        
        f(ans+'(',open-1,close,res);
        
        f(ans+')',open,close-1,res);
    }
}
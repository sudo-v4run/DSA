class Solution {
    public List<String> letterCombinations(String digits) {
        
        // HashMap<Character,String> hm = new HashMap<>();
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> res = new ArrayList<>();
        
        // hm.put('2',"abc");
        // hm.put('3',"def");
        // hm.put('4',"ghi");
        // hm.put('5',"jkl");
        // hm.put('6',"mno");
        // hm.put('7',"pqrs");
        // hm.put('8',"tuv");
        // hm.put('9',"wxyz");
        
        int n = digits.length();
        
        if(digits.equals(""))
            return res;
        
        f(0,digits,"",res,arr);
        
        return res;
    }
    public static void f(int index,String s,String ans,
                                    List<String> res,String[] arr){
        
        if(index>s.length()-1){
            res.add(ans);
            return;
        }
        
        char num = s.charAt(index);
        String chars = arr[Integer.parseInt(String.valueOf(num))];
        
        for(char ch : chars.toCharArray()){
            ans+=ch;
            f(index+1,s,ans,res,arr);
            ans = ans.substring(0,ans.length()-1);
        }
        
    }
}
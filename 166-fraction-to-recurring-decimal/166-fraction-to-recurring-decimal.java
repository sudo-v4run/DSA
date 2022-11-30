class Solution {
    public String fractionToDecimal(int num, int den) {
        StringBuilder ans = new StringBuilder();
        
        if (num == 0) {
            return "0";
        }
        
        ans.append(((num > 0) ^ (den > 0)) ? "-" : "");
        
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);
        
        long q = numerator/denominator;
        long r = numerator%denominator;
        
        ans.append(q);
        
        if(r==0){
            return ans.toString();
        }else{
            ans.append(".");
            HashMap<Long,Integer> hm = new HashMap<>();
            while(r!=0){
                if(hm.containsKey(r)){
                    int len = hm.get(r);
                    ans.insert(len,"(");
                    ans.append(")");
                    break;
                }else{
                    hm.put(r,ans.length());
                    r = r*10;
                    q = r/denominator;
                    r = r%denominator;
                    ans.append(q);
                }
            }
        }
        
        return ans.toString();
    }
}
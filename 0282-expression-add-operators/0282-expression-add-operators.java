/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {

        List<String> res = new ArrayList<String>();
        
        f(0, "", 0, 0, target, num, res);

        return res;
    }
    public static void f(int index, String path, long prev, long value, int t, String num, 
                            List<String> res){

        int n = num.length();
        if(index == n){
            if(value == t){
                res.add(path);
            }
            return;
        }

        for(int i = index; i < n; i++){

            long curDigit = Long.parseLong(num.substring(index, i+1));

            if(i != index && num.charAt(index) == '0'){
                return;
            }

            if(index == 0){
                f(i+1, path+curDigit, curDigit, curDigit, t, num, res);
            }else{
                f(i+1, path+"+"+curDigit, curDigit, value+curDigit, t, num, res);
                f(i+1, path+"-"+curDigit, -curDigit, value-curDigit, t, num, res);
                f(i+1, path+"*"+curDigit, prev*curDigit, value-prev+prev*curDigit, t, num, res);
            }
        }
    }
}
// @lc code=end


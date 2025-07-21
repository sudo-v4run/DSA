class Solution {
    public String longestCommonPrefix(String[] strs) {

        String res = "";
        int i = 0;

        while(true){

            if(i >= strs[0].length()){
                return res;
            }

            char cur = strs[0].charAt(i);
            
            for(int j = 0 ; j < strs.length ; j++){

                if(i >= strs[j].length() || strs[j].charAt(i) != cur){
                    return res;
                }
            }

            res += cur;
            i++;
        }
    }
}
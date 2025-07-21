class Solution {
    public String longestCommonPrefix(String[] strs) {

        String res = "";

        int i = 0;

        while(true){
            
            for(int j = 0 ; j < strs.length ; j++){

                if(i >= strs[j].length()){
                    return res;
                }

                char cur = strs[0].charAt(i);

                if(strs[j].charAt(i) != cur){
                    return res;
                }
            }

            res += strs[0].charAt(i);

            i++;
        }
    }
}
class Solution {
    public int lengthLongestPath(String input) {
        
        input = input.replace("\n","/");
        String inp[] = input.split("/");
        for(int index = 0; index < inp.length; index++){
            String x = inp[index];
            int t = 0;
            boolean tFound = false;
            for(int i = 0; i < x.length(); i++){
                if(x.charAt(i) == '\t'){
                    t++;
                    tFound = true;
                }
            }
            if(tFound){
                x = x.replace(x.substring(0, t),t+"-");
                inp[index] = x;
            }
        }

        // for(String x : inp){
        //     System.out.println(x);
        // }

        Stack<String> st = new Stack<>();
        int longest = 0;
        int length = 0;

        for(int index = 0; index < inp.length; index++){
            String cur = inp[index];
            if(cur.indexOf("-") != -1){
                int level = Integer.parseInt(cur.substring(0,cur.indexOf("-")));
                while(!st.isEmpty() && st.peek().indexOf("-") != -1 && Integer.parseInt(st.peek().substring(0,st.peek().indexOf("-"))) >= level){
                    length = length-st.peek().substring(st.peek().indexOf("-")).length();
                    st.pop();
                }
                st.push(cur);
                length = length+cur.substring(cur.indexOf("-")).length();
            }else{
                length = cur.length();
                st.push(cur);
            }

            if(cur.indexOf(".") != -1){
                longest = Math.max(longest, length);
                if(cur.indexOf("-") != -1){
                    length = length-st.peek().substring(st.peek().indexOf("-")).length();
                }else{
                    length = length-st.peek().length();
                }
                
                st.pop();
            }
        }

        return longest;
    }
}
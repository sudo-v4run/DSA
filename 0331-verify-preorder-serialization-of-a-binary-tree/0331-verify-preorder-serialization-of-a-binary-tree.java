class Solution {
    public boolean isValidSerialization(String preorder) {
        
        Stack<Character> st = new Stack<>();
        String pre[] = preorder.split(",");

        int index = 1;
        char prev = 'a';
        st.push(pre[0].charAt(0));

        while(!st.isEmpty()){
            if(!st.isEmpty() && st.peek() == prev && prev == '#'){
                st.pop();
                st.pop();
                if(st.isEmpty()){
                    return false;
                }
                st.pop();

                if(!st.isEmpty()){
                    prev = st.peek();
                }else{
                    prev = 'a';
                }

                st.push('#');
            }else{
                prev = st.peek();
                if(index == pre.length){
                    break;
                }
                st.push(pre[index++].charAt(0));
            }
        }

        return st.size() == 1 && st.peek() == '#';
    }
}
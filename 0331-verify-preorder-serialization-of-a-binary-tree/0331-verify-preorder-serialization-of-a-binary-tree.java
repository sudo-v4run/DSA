class Solution {
    public boolean isValidSerialization(String preorder) {
        
        Stack<Character> st = new Stack<>();
        String temp[] = preorder.split(",");

        char pre[] = new char[temp.length];
        int i = 0;
        for(String s : temp){
            pre[i++] = s.charAt(0);
        }

        int index = 1;
        char prev = 'a';
        st.push(pre[0]);

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
                st.push(pre[index++]);
            }
        }

        return st.size() == 1 && st.peek() == '#';
    }
}
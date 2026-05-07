class Solution {
    public int lengthLongestPath(String input) {
        
        String filesOrFolders[] = input.split("\n");

        Stack<Integer> st = new Stack<>();
        st.push(0);
        int longest = 0;
        for(String cur : filesOrFolders){
            int level = cur.lastIndexOf("\t")+1;
            while(st.size()-1 > level){
                st.pop();
            }
            int len = st.peek()+cur.length()-level+1;
            st.push(len);

            if(cur.indexOf(".") != -1){
                longest = Math.max(longest, len-1); // -1 for added / in case of file
            }
        }

        return longest;
    }
}
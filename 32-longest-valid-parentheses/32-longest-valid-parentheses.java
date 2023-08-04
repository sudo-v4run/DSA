class Solution {
    public int longestValidParentheses(String s) {
        
        // 2 stacks..

        Stack<Character> chr = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        ind.push(-1);
        
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                chr.push('(');
                ind.push(i);
            }else if(ch == ')'){
                if(!chr.isEmpty() && chr.peek() == '('){
                    chr.pop();
                    ind.pop();
                    int len = i-ind.peek();
                    max = Math.max(max,len);
                }else{
                    ind.push(i);
                }
            }
        }

        return max;
    }
}
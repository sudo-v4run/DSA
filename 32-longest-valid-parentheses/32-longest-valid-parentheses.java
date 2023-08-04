class Solution {
    public int longestValidParentheses(String s) {
        
        // 2 variables...
        
        int open = 0;
        int close = 0;
        
        int max = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                close++;
            }
            
            if(open == close){
                max = Math.max(max,2*open);
            }else if(close > open){
                open = close = 0;
            }
        }
        
        open = close = 0;
        
        for(int i = s.length()-1 ; i >= 0 ; i--){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                close++;
            }
            
            if(open == close){
                max = Math.max(max,2*open);
            }else if(open > close){
                open = close = 0;
            }
        }
        
        return max;
        
        
        
        // 2 stacks..

//         Stack<Character> chr = new Stack<>();
//         Stack<Integer> ind = new Stack<>();
//         ind.push(-1);
        
//         int max = 0;
//         for(int i = 0 ; i < s.length() ; i++){
//             char ch = s.charAt(i);
//             if(ch == '('){
//                 chr.push('(');
//                 ind.push(i);
//             }else if(ch == ')'){
//                 if(!chr.isEmpty() && chr.peek() == '('){
//                     chr.pop();
//                     ind.pop();
//                     int len = i-ind.peek();
//                     max = Math.max(max,len);
//                 }else{
//                     ind.push(i);
//                 }
//             }
//         }

//         return max;
    }
}
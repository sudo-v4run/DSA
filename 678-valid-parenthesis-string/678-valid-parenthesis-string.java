class Solution {
    public boolean checkValidString(String s) {
        
        // Greedy...TC -> O(n) and SC -> O(1)...
        
        int n = s.length();
        
        int openMin = 0;
        int openMax = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                openMin++;
                openMax++;
            }else if(ch == '*'){
                openMin--;  // * == )
                openMax++;  // * == (
            }else{
                openMin--;
                openMax--;
            }
            
            if(openMax < 0){
                
                // if openMax < 0, it means that there were more right parenthesis.
                // ')' can't be more than '(' at any point... 
                
                return false;
            }
            
            if(openMin < 0){
                    
                // openMin can't be -ve to be valid .i.e we choose the 
                // * wrongly to be ( . So don't consider it.i.e make the 
                // openMin = 0...
                // coz openMin and openMax represents the valid range of 
                // possibilities...
                // openMin < 0 means that * shouldn't have been treated as
                // ) at some point of *

                openMin = 0;
            }
        }
        
        // In the end if openMin is positive, it means that there are atleast a
        // openMin number of right parenthesis extra. -> return false...
        
        return openMin == 0;
        
        
        
        
        
        
        // Using Stacks...TC and SC -> O(n)...
        
//         Stack<Integer> open = new Stack<>();
//         Stack<Integer> star = new Stack<>();
        
//         for(int i = 0 ; i < s.length() ; i++){
//             char ch = s.charAt(i);
            
//             if(ch == '('){
//                 open.push(i);
//             }else if(ch == '*'){
//                 star.push(i);
//             }else{  // balancing ) paranthesis...
//                 if(!open.isEmpty()){
//                     open.pop();
//                 }else if(!star.isEmpty()){
//                     star.pop();
//                 }else{
//                     return false;
//                 }
//             }
//         }
        
//         // balancing ( paranthesis...
        
//         while(!open.isEmpty()){
            
//             if(star.isEmpty()){
//                 return false;
//             }
//             if(star.peek() < open.peek()){    
//                     // * should be present to the right of ( to be valid..
//                     // so if index of * < index of ( , return false...
//                 return false;
//             }
//             star.pop();
//             open.pop();
//         }
        
//         return true;
    }
}
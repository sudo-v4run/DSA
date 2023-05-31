class Solution {
    public boolean checkValidString(String s) {
        
        // Greedy...TC -> O(n) and SC -> O(1)...
        
        int n = s.length();
        
        int leftMin = 0;
        int leftMax = 0;
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                leftMin++;
                leftMax++;
            }else if(ch == '*'){
                leftMin--;  // * == )
                leftMax++;  // * == (
            }else{
                leftMin--;
                leftMax--;
            }
            
            if(leftMax < 0){
                // if leftMax < 0, it means that there were more right parenthesis
                // '(' can't be more than ')' at any point... 
                return false;
            }
            
            if(leftMin < 0){
                    
                // leftMin can't be -ve to be valid .i.e we choose the 
                // * wrongly to be ( . So don't consider it.i.e make the 
                // leftMin = 0...
                // coz leftMin and leftMax represents the valid range of 
                // possibilities...

                leftMin = 0;
            }
        }
        
        return leftMin == 0;
        
        
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
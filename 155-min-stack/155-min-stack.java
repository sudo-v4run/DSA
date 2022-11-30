class MinStack {
    
    Stack<Long> st;
    long mini;

    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()){
            st.push(val);
            mini = val;
        }else{
            if(val<mini){
                st.push(2*val-mini);
                mini = val;
            }else{
                st.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }else{
            Long val = st.pop();
            if(val<mini){
                mini = 2*mini-val;
            }
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val<mini){
            return (int)mini;
        }
        
        return val.intValue();
    }
    
    public int getMin() {
        return (int)mini;
    }
    
    
    // SC- O(2N) -> use another stack to maintain minEles...

    
//     Using Pair class...
    
//     class Pair{
//         int val;
//         int min;
//         Pair(int val,int min){
//             this.val = val;
//             this.min = min;
//         }
//     }
//     Stack<Pair> st;
//     public MinStack() {
//         st = new Stack<>();
//     }
    
//     public void push(int val) {
//         if(st.isEmpty()){
//             st.push(new Pair(val,val));
//         }else{
//             int min = st.peek().min;
//             if(val<=min){
//                 st.push(new Pair(val,val));
//             }else{
//                 st.push(new Pair(val,min));
//             }
//         }
//     }
    
//     public void pop() {
//         if(st.isEmpty()){
//             return;
//         }else{
//             st.pop();
//         }
//     }
    
//     public int top() {
//         if(st.isEmpty()){
//             return -1;
//         }else{
//             return st.peek().val;
//         }
//     }
    
//     public int getMin() {
//         if(st.isEmpty()){
//             return -1;
//         }else{
//             return st.peek().min;
//         }
//     }
    
}
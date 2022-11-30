class MinStack {
    
    class Pair{
        int val;
        int min;
        Pair(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            int min = st.peek().min;
            if(val<=min){
                st.push(new Pair(val,val));
            }else{
                st.push(new Pair(val,min));
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }else{
            st.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }else{
            return st.peek().val;
        }
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }else{
            return st.peek().min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
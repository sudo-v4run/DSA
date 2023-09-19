class StockSpanner {

    class Pair{
        int ele,cnt;
        Pair(int ele, int cnt){
            this.ele = ele;
            this.cnt = cnt;
        }
    }
    
    Stack<Pair> s;
    public StockSpanner() {
        
        s = new Stack<>();
    }
    
    public int next(int price) {
        
        int cnt = 1;
        while(!s.isEmpty() && s.peek().ele <= price){
            cnt += s.pop().cnt;
        }
        s.push(new Pair(price,cnt));
        
        return cnt;
    }
}
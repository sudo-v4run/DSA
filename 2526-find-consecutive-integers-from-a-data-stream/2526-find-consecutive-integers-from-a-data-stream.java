class DataStream {

    int cnt;
    int val;
    int k;
    public DataStream(int value, int k) {
        
        cnt = 0;
        val = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        
        if(num == val){
            cnt++;
            
            if(cnt >= k){
                return true;
            }
        }else{
            cnt = 0;
            return false;
        }
        
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
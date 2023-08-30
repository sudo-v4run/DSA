class KthLargest {
    
    PriorityQueue<Integer> pq;
    
    int k;

    public KthLargest(int K, int[] arr) {
        k = K;
        pq = new PriorityQueue<>();
        
        int n = arr.length;
        
        for(int i = 0 ; i < k && i < n ; i++){
            pq.add(arr[i]);
        }
        
        for(int i = k ; i < n ; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
    }
    
    public int add(int val) {
        
        if(pq.size() < k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}
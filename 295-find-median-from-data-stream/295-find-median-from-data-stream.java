class MedianFinder {
    Queue<Integer> minH,maxH;
    boolean isEven = true;
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int x) {
        if(isEven){
            minH.offer(x);
            maxH.offer(minH.poll());
        }else{
            maxH.offer(x);
            minH.offer(maxH.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if(isEven){
            return (minH.peek()+maxH.peek())/2.0;
        }else{
            return maxH.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
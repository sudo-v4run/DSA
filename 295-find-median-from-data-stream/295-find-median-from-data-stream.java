class MedianFinder {
    
    PriorityQueue<Integer> max,min;

    public MedianFinder() {
        
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(max.size() == min.size()){
            max.add(num);
        }else{
            min.add(num);
        }
        
        if(!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()){
            min.add(max.poll());
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        
        if(max.size() == min.size()){
            return (max.peek()+min.peek())/2.0;
        }
        
        return max.peek();
    }
}
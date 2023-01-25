class MedianFinder {

    static ArrayList<Integer> arr;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        arr = new ArrayList<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        
        if((maxHeap.size()+minHeap.size())%2==0){
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        }
        
        return maxHeap.peek();
    }
}
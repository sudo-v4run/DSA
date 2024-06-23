class Solution {
    public double minimumAverage(int[] arr) {
        
        int n = arr.length;
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : arr){
            minPq.add(x);
            maxPq.add(x);
        }
        
        PriorityQueue<Double> resPq = new PriorityQueue<>();
        
        while(minPq.size() > n/2){
            
            int min = minPq.poll();
            int max = maxPq.poll();
            
            double avg = (min+max)/2.0;
            
            resPq.add(avg);
        }
        
        return resPq.peek();
    }
}
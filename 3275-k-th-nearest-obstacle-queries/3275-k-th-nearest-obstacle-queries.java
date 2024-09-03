class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        
        int n = queries.length;
        
        int res[] = new int[n];
        int index = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int q[] : queries){
            int x = q[0];
            int y = q[1];
            int sum = Math.abs(x)+Math.abs(y);
            
            pq.add(sum);
            
            if(k > pq.size()){
                res[index++] = -1;
                continue;
            }
            if(pq.size() > k){
                pq.poll();
            }
            
            res[index++] = pq.peek();
        }
        
        return res;
    }
}
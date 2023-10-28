class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue((a,b)->{
                return -1*(((((int[])a)[0]*((int[])a)[0])+(((int[])a)[1]*((int[])a)[1])) - 
                    ((((int[])b)[0]*((int[])b)[0])+(((int[])b)[1]*((int[])b)[1])));
        });
        
        int res[][] = new int[k][2];
        int j = 0;
        
        for(int point[] : points){
            pq.add(point);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            res[j++] = pq.poll();
        }
        
        return res;
    }
}
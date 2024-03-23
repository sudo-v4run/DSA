class Solution {
    public int maximumProduct(int[] arr, int k) {
        
        int MOD = (int)1e9+7;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x : arr){
            pq.add(x);
        }
        
        while(k > 0){
            int pop = pq.poll();
            pop++;
            k--;
            pq.add(pop);
        }
        
        long res = 1;
        while(!pq.isEmpty()){
            res = (res*pq.poll())%MOD;
        }
        
        return (int)res;
    }
}
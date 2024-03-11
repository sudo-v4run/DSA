class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        
        int n = arr.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int h : arr){
            pq.add(h);
        }
        
        long res = 0;
        int turn = 0;
        int cnt = 0;
        
        while(!pq.isEmpty()){
            if(cnt == k){
                break;
            }
            int cur = pq.poll();
            
            if(cur-turn >= 0){
                res += cur;
                res = res - turn;
            }
            cnt++;
            turn++;
        }
        
        return res;
    }
}
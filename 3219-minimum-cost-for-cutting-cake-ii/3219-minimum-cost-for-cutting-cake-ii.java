class Solution {
    
    int horizontalCut[];
    int verticalCut[];
    PriorityQueue<Integer> hPq;
    PriorityQueue<Integer> vPq;
    
    public long minimumCost(int M, int N, int[] horizontalCut, int[] verticalCut) {
        
        int m = horizontalCut.length;
        int n = verticalCut.length;
        
        this.horizontalCut = horizontalCut;
        this.verticalCut = verticalCut;
        hPq = new PriorityQueue<>(Collections.reverseOrder());
        vPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < m ; i++){
            hPq.add(horizontalCut[i]);
        }
        for(int i = 0 ; i < n ; i++){
            vPq.add(verticalCut[i]);
        }
        
        return f(1,1,m+1,n+1);
    }
    public long f(int horiPcs, int vertiPcs, int m, int n){
        
        if(horiPcs == m && vertiPcs == n){
            return 0;
        }
        
        long ans = (long)1e18;
        
        int h = -1;
        if(hPq.size() != 0){
            h = hPq.peek();
        }
        int v = -1;
        if(vPq.size() != 0){
            v = vPq.peek();
        }
        
        if(v != -1 && h != -1){
            if(v > h){
                vPq.poll();
                long cur = horiPcs*v + f(horiPcs,vertiPcs+1,m,n);
                ans = Math.min(ans,cur);
            }else{
                hPq.poll();
                long cur = vertiPcs*h + f(horiPcs+1,vertiPcs,m,n);
                ans = Math.min(ans,cur);
            }
        }else if(v != -1){
            vPq.poll();
            long cur = horiPcs*v + f(horiPcs,vertiPcs+1,m,n);
            ans = Math.min(ans,cur);
        }else if(h != -1){
            hPq.poll();
            long cur = vertiPcs*h + f(horiPcs+1,vertiPcs,m,n);
            ans = Math.min(ans,cur);
        }
        
        return ans;
    }
}
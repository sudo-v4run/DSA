class Solution {
    class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        // Use QuickSelect for O(N) in Avg case and O(N^2) in worst case....
        
        // PQ...TC-> O(n.logk)...
        
        int n = points.length;
        Pair[] arr = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Pair(points[i][0],points[i][1]);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return (b.x*b.x + b.y*b.y)-(a.x*a.x + a.y*a.y);
        });
        
        int res[][] = new int[k][2];
        int j = 0;
        
        for(Pair p : arr){
            pq.add(p);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            res[j][0] = cur.x;
            res[j][1] = cur.y;
            j++;
        }
        
        return res;
    }
}
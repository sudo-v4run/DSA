class Solution {
    public int minCostConnectPoints(int[][] points) {

        Arrays.sort(points,(a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.dist-b.dist;});

        for(int i = 0 ; i < points.length ; i++){
            int xi = points[i][0];
            int yi = points[i][1];
            for(int j = i+1 ; j < points.length ; j++){
                if(i == j){
                    continue;
                }
                int xj = points[j][0];
                int yj = points[j][1];

                int dist = Math.abs(xi-xj)+Math.abs(yi-yj);

                pq.add(new Pair(dist,xi+","+yi,xj+","+yj));
            }
        }

        HashSet<String> vis = new HashSet<>();

        int res = 0;
     
        while(!pq.isEmpty()){

            Pair pop = pq.poll();
            int dist = pop.dist;
            String point1 = pop.point1;
            String point2 = pop.point2;

            //System.out.println(dist+"   "+point2);

            if(vis.contains(point2)){
                
                continue;
            }
            //System.out.println(dist);

            res += dist;
            //vis.add(point1);
            vis.add(point2);
    
        }

        return res;
    }
    class Pair{
        int dist;
        String point1;
        String point2;
        Pair(int dist, String point1, String point2){
            this.dist = dist;
            this.point1 = point1;
            this.point2 = point2;
        }
    }
}
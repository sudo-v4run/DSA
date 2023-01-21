class Solution {
    public int maxPoints(int[][] points) {
        
        int n = points.length;
        
        if(n<=2){
            return n;
        }
        
        Map<Double,Integer> hm = new HashMap();
        int max = 0;
        
        for(int i = 0 ; i < n ; i++){
            int iMax = 0;
            for(int j = i+1 ; j < n ; j++){
                
                double slope = 1e9;
                int y2=points[j][1], y1=points[i][1];
                int x2=points[j][0], x1=points[i][0];
                
                int numerator = y2-y1;
                int denominator = x2-x1;
                
                if(numerator==0){
                    slope = 0.0;
                }else if(denominator != 0){
                    slope = (double)numerator/(double)denominator;
                }
                
                System.out.println(slope);
                
                hm.put(slope,hm.getOrDefault(slope,1)+1);
                iMax = Math.max(iMax,hm.get(slope));
            }
            max = Math.max(max,iMax);
            hm.clear();
        }
        
        return max;
    }
}
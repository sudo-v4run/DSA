class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        
        int minInd = 0;
        int maxInd = 0;

        for(int index = 0; index < rectangles.length; index++){

            if(rectangles[index][0] < rectangles[minInd][0]){
                minInd = index;
            }else if(rectangles[index][0] == rectangles[minInd][0]){
                if(rectangles[index][1] < rectangles[minInd][1]){
                    minInd = index;
                }
            }

            if(rectangles[index][2] > rectangles[maxInd][2]){
                maxInd = index;
            }else if(rectangles[index][2] == rectangles[maxInd][2]){
                if(rectangles[index][3] > rectangles[maxInd][3]){
                    maxInd = index;
                }
            }
        }

        HashSet<String> hs = new HashSet<>();
        int area = 0;

        // all inside sides of the rectangles should be even and if u found even, remove 
        // from HashSet. After inner overlapping sides cancel out each other, only
        // outer sides of rectangle- all 4 coords should remain in case of perfect
        // rectangle.

        for(int index = 0; index < rectangles.length; index++){

            int x = rectangles[index][0];
            int y = rectangles[index][1];
            int a = rectangles[index][2];
            int b = rectangles[index][3];

            String c1 = x+","+y;
            String c2 = a+","+b;
            String c3 = x+","+b;
            String c4 = a+","+y;
            
            if(hs.contains(c1)){
                hs.remove(c1);
            }else{
                hs.add(c1);
            }

            if(hs.contains(c2)){
                hs.remove(c2);
            }else{
                hs.add(c2);
            }

            if(hs.contains(c3)){
                hs.remove(c3);
            }else{
                hs.add(c3);
            }

            if(hs.contains(c4)){
                hs.remove(c4);
            }else{
                hs.add(c4);
            }

            area += (a-x)*(b-y);
        }

        if( hs.size() != 4 ||
        !hs.contains(rectangles[minInd][0]+","+rectangles[minInd][1]) ||
        !hs.contains(rectangles[maxInd][2]+","+rectangles[maxInd][3]) || 
        !hs.contains(rectangles[minInd][0]+","+rectangles[maxInd][3]) || 
        !hs.contains(rectangles[maxInd][2]+","+rectangles[minInd][1]) ){
            
            return false;
        }

        int globalArea = (rectangles[maxInd][2]-rectangles[minInd][0])
                    *(rectangles[maxInd][3]-rectangles[minInd][1]);

        return area == globalArea;
    }
}
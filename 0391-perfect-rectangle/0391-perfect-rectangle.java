class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        int minXInd = 0;
        int minYInd = 0;

        int maxXInd = 0;
        int maxYInd = 0;

        for(int index = 0; index < rectangles.length; index++){

            if(rectangles[index][0] < rectangles[minXInd][0]){
                minXInd = index;
                minYInd = index;
            }else if(rectangles[index][0] == rectangles[minXInd][0]){
                if(rectangles[index][1] < rectangles[minYInd][1]){
                    minXInd = index;
                    minYInd = index;
                }
            }

            if(rectangles[index][2] > rectangles[maxXInd][2]){
                maxXInd = index;
                maxYInd = index;
            }else if(rectangles[index][2] == rectangles[maxXInd][2]){
                if(rectangles[index][3] > rectangles[maxYInd][3]){
                    maxXInd = index;
                    maxYInd = index;
                }
            }
        }
        
        int leftBottomX = minXInd;
        int leftBottomY = minYInd;

        int rightTopX = maxXInd;
        int rightTopY = maxYInd;

        int area = (rectangles[rightTopX][2]-rectangles[leftBottomX][0])
                    *(rectangles[rightTopY][3]-rectangles[leftBottomY][1]);

        //System.out.println(minXInd+","+minYInd+","+maxXInd+","+maxYInd);

        HashSet<String> hs = new HashSet<>();

        int areaSum = 0;

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


            areaSum += (a-x)*(b-y);
        }

        int xInd = minXInd;
        int aInd = maxXInd;

        if( hs.size() != 4 ||
        !hs.contains(rectangles[xInd][0]+","+rectangles[xInd][1]) ||
        !hs.contains(rectangles[aInd][2]+","+rectangles[aInd][3]) || 
        !hs.contains(rectangles[xInd][0]+","+rectangles[aInd][3]) || 
        !hs.contains(rectangles[aInd][2]+","+rectangles[xInd][1]) ){
            
            return false;
        }

        return areaSum == area;
    }
}
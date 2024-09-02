class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        
        int x1 = coordinate1.charAt(0)-'a'+1;
        int y1 = Integer.parseInt(coordinate1.charAt(1)+"");
        
        int x2 = coordinate2.charAt(0)-'a'+1;
        int y2 = Integer.parseInt(coordinate2.charAt(1)+"");
        
        int color1 = 0;
        
        if(x1%2 != 0){
            if(y1%2 != 0){
                color1 = 0;
            }else{
                color1 = 1;
            }
        }else{
            if(y1%2 != 0){
                color1 = 1;
            }else{
                color1 = 0;
            }
        }
        
        int color2 = 0;
        
        if(x2%2 != 0){
            if(y2%2 != 0){
                color2 = 0;
            }else{
                color2 = 1;
            }
        }else{
            if(y2%2 != 0){
                color2 = 1;
            }else{
                color2 = 0;
            }
        }
        
        return color1 == color2;
    }
}
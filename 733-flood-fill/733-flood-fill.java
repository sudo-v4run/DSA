class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        int initColr = image[sr][sc];
        
        dfs(sr,sc,image,initColr,color);
        
        return image;
    }
    public static void dfs(int sr, int sc, int image[][], int initColr, int newColr){
        
        if( sr<0 || sr >= image.length || sc < 0 || sc >= image[0].length ||
            image[sr][sc] != initColr || image[sr][sc] == newColr ){
            
            return;
        }
        
        image[sr][sc] = newColr;
        
        dfs(sr-1,sc,image,initColr,newColr);
        dfs(sr,sc-1,image,initColr,newColr);
        dfs(sr+1,sc,image,initColr,newColr);
        dfs(sr,sc+1,image,initColr,newColr);
    }
}
class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        
        int m = image.length;
        int n = image[0].length;
        
        ArrayList<Integer>[][] temp = new ArrayList[m][n];
        
        for(int i = 0 ; i <= m-3 ; i++){
            for(int j = 0 ; j <= n-3 ; j++){
                int sum = 0;
                boolean isRegion = true;
                for(int k = i ; k < i+3 ; k++){
                    for(int l = j ; l < j+3 ; l++){
                        int cur = image[k][l];
                        sum += cur;
                        
                        if((k-1 >= i && Math.abs(cur-image[k-1][l]) > threshold) ||
                           (k+1 <= i+2 && Math.abs(cur-image[k+1][l]) > threshold)){
                            
                            isRegion = false;
                            break;
                        }
                        if((l-1 >= j && Math.abs(cur-image[k][l-1]) > threshold) || 
                           (l+1 <= j+2 && Math.abs(cur-image[k][l+1]) > threshold)){
                            
                            isRegion = false;
                            break;
                        }
                    }
                }
                if(isRegion){
                    for(int k = i ; k < i+3 ; k++){
                        for(int l = j ; l < j+3 ; l++){
                            if(temp[k][l] == null)
                                temp[k][l] = new ArrayList<Integer>();
                            temp[k][l].add(sum/9);
                        }
                    }
                }
            }
        }
        
        int res[][] = image;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(temp[i][j] != null){
                    ArrayList<Integer> cur = temp[i][j];
                    int sz = cur.size();
                    int s = 0;
                    for(int ele : cur){
                        s += ele;
                    }
                    int avg = s/sz;
                    
                    res[i][j] = avg;
                }
            }
        }
        
        return res;
    }
}
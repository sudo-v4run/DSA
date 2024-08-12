class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        
        int arr[][] = new int[n][n];

        int p = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = p;
                p++;
            }
        }

        int i = 0, j = 0;
        for(String c : commands){

            if(c.equals("UP")){
                i--;
            }else if(c.equals("LEFT")){
                j--;
            }else if(c.equals("DOWN")){
                i++;
            }else{
                j++;
            }
        }

        return arr[i][j];
    }
}
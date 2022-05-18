class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> res = new ArrayList<>();
     
        int left = 0;
        int right = arr[0].length-1;
        int top = 0;
        int bottom = arr.length-1;
        int dir = 0;
        
        while(top<=bottom  && left<=right  ){
            if(dir==0){
                for(int i = left ; i<=right ; i++){
                    res.add(arr[top][i]);
                }
                top++;
            }
            else if(dir==1){
                for(int i = top ; i <= bottom ; i++){
                    res.add(arr[i][right]);
                }
                right--;
            }
            else if(dir==2){
                for(int i = right ; i >= left ; i--){
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }
            else if(dir==3){
                for(int i = bottom ; i >=top;i--){
                    res.add(arr[i][left]);
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        
        return res;
    }
}
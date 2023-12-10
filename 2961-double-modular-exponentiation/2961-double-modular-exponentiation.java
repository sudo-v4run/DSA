  
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        
        int n = variables.length;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            int cur[] = variables[i];
            
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            int m = cur[3];
            
            int temp1 = 1;
            
            for(int j = 0 ; j < b ; j++){
                temp1 = (temp1*a)%10;
            }
            
            int temp2 = 1;
            for(int j = 0 ; j < c ; j++){
                temp2 = (temp2*temp1)%m;
            }
            
            if(temp2 == target){
                res.add(i);
            }
        }
        
        return res;
    }
}
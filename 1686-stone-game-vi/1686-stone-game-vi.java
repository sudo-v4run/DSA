class Solution {
    public int stoneGameVI(int[] a, int[] b) {
        
        int n = a.length;
        
        int sum[][] = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            sum[i][0] = a[i]+b[i];
            sum[i][1] = a[i];
            sum[i][2] = b[i];
        }
        
        Arrays.sort(sum,(aa,bb)->{
            return bb[0]-aa[0];
        });
        
        int aScore = 0;
        int bScore = 0;
        
        for(int i= 0 ; i < n ; i++){
            if(i%2 == 0){
                aScore += sum[i][1];
            }else{
                bScore += sum[i][2];
            }
        }
        
        if(aScore > bScore){
            return 1;
        }else if(bScore > aScore){
            return -1;
        }
        return 0;
    }
}
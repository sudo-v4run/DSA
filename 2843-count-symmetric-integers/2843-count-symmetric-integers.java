class Solution {
    public int countSymmetricIntegers(int low, int high) {
        
        int cnt = 0;
        
        for(int i = low ; i <= high ; i++){
            String temp = String.valueOf(i);
            int pre = 0;
            int suf = 0;
            if(temp.length() % 2 != 0){
                continue;
            }
            for(int j = 0 ; j < temp.length()/2 ; j++){
                pre += temp.charAt(j);
            }
            for(int j = temp.length()/2 ; j < temp.length() ; j++){
                suf += temp.charAt(j);
            }
            if(pre == suf){
                cnt++;
            }
        }
        
        return cnt;
    }
}
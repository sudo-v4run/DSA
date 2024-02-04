class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        
        String temp = word;
        
        int cnt = 0;
        
        do{
            if(temp.length() < k){
                cnt++;
                break;
            }
            temp = temp.substring(k);
            cnt++;
        }while(temp.length() >= 0 && word.indexOf(temp) != 0);
        
        return cnt;
    }
}
class Solution {
    public String maximumOddBinaryNumber(String s) {
        
        int n = s.length();
        
        char charr[] = new char[n];
        Arrays.fill(charr,'0');
        
        charr[n-1] = '1';
        
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                cnt++;
            }
        }
        
        if(cnt == 1){
            return String.valueOf(charr);
        }
        
        cnt--;
        
        for(int i = 0 ; i < n && cnt > 0 ; i++){
            charr[i] = '1';
            cnt--;
        }
        
        return String.valueOf(charr);
    }
}
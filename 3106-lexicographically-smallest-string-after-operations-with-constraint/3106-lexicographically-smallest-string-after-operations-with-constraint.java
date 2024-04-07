class Solution {
    public String getSmallestString(String s, int k) {
        
        char ans[] = s.toCharArray();
        
        int n = s.length();
        
        for(int i = 0 ; i < n ; i++){
            if(k <= 0){
                break;
            }
            char ch = s.charAt(i);
            int d = distanceToReachA(ch);
            if(d <= k){
                ans[i] = 'a';
                k = k-d;
            }else{
                ans[i] = (char)((int)ans[i]-k);
                k = 0;
            }
        }
        
        return String.valueOf(ans);
    }
    public int distanceToReachA(char ch){
        
        int d1 = Math.abs(ch-'a');
        int d2 = 26-d1;
        
        return Math.min(d1,d2);
    }
}
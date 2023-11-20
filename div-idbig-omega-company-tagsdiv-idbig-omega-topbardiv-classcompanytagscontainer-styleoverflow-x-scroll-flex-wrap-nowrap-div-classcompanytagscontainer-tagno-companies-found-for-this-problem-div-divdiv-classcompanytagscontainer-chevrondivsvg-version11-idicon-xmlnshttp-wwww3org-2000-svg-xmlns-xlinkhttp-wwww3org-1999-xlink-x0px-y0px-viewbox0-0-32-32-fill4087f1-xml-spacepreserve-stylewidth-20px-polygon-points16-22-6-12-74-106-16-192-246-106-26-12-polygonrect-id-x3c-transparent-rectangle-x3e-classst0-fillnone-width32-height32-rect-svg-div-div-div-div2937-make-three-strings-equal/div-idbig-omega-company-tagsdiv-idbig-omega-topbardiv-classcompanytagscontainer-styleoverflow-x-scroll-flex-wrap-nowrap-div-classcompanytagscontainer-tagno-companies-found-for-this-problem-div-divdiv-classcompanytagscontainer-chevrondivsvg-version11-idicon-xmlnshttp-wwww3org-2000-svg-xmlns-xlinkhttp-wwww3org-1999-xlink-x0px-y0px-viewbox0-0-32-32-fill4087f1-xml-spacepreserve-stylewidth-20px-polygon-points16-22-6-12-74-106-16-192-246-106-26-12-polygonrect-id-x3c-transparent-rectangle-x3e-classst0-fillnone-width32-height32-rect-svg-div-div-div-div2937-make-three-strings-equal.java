class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        int minLen = Math.min(n1,Math.min(n2,n3));
        int i = 0;
        
        while(i < minLen && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)){
            i++;
        }
        
        if(i == 0){
            return -1;
        }
        
        int cnt = n1-i;
        cnt += n2-i;
        cnt += n3-i;
        
        return cnt;
    }
}
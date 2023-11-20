class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        int minLen = Math.min(n1,Math.min(n2,n3));
        
        int cnt = 0;
        cnt += n1-minLen;
        cnt += n2-minLen;
        cnt += n3-minLen;
        
        for(int i = minLen-1 ; i >= 0 ; i--){
            String temp1 = s1.substring(0,i+1);
            String temp2 = s2.substring(0,i+1);
            String temp3 = s3.substring(0,i+1);
            
            if(!temp1.equals(temp2)){
                cnt += 3;
                continue;
            }
            if(!temp2.equals(temp3)){
                cnt += 3;
                continue;
            }
            if(!temp3.equals(temp1)){
                cnt += 3;
                continue;
            }
        }
        
        if(cnt == n1+n2+n3){
            return -1;
        }
        return cnt;
    }
}
class Solution {
    public long sumDigitDifferences(int[] arr) {
        
        int n = arr.length;
        int prefix[][] = new int[10][10];
        
        for(int i = 0 ; i < n ; i++){
            
            String cur = String.valueOf(arr[i]);
            
            for(int j = 0 ; j < cur.length() ; j++){
                prefix[j][cur.charAt(j)-'0']++;
            }
        }
        
        long ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            String cur = String.valueOf(arr[i]);
            
            for(int j = 0 ; j < cur.length() ; j++){
                ans += n-prefix[j][cur.charAt(j)-'0'];
            }
        }
        
        return ans/2;  // by 2 coz each pair is calculated twice in the above process..
    }
}
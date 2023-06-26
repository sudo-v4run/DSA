class Solution {
    public int countBeautifulPairs(int[] arr) {
        
        int n = arr.length;
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                char a = String.valueOf(arr[i]).charAt(0);
                int b = arr[j];
                
                if(gcd(a-'0',b%10) == 1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b,a%b);
    }
}
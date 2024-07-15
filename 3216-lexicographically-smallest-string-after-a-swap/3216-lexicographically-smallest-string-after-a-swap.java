class Solution {
    public String getSmallestString(String s) {
        
        int n = s.length();
        
        char arr[] = s.toCharArray();
        
        for(int i = 1 ; i < n ; i++){
            int cur = arr[i]-'0';
            int prev = arr[i-1]-'0';
            
            if((cur%2)==(prev%2) && cur < prev){
                char temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                break;
            }
        }
        
        return String.valueOf(arr);
    }
}
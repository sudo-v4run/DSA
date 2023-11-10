class Solution {
    public String breakPalindrome(String palindrome) {
        
        int n = palindrome.length();
        
        if(n == 1){
            return "";
        }
        
        char arr[] = palindrome.toCharArray();
        
        int i = 0;
        while(i < n && arr[i] == 'a'){
            i++;
        }
        
        if(i == n){         // if all are a
            arr[n-1] = 'b';
            return new String(arr);
        }
        
        if(i != n/2){
            arr[i] = 'a';
            return new String(arr);
        }
        
        arr[n-1] = 'b';
        
        return new String(arr);
    }
}
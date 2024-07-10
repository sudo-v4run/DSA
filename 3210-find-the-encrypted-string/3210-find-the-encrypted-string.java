class Solution {
    public String getEncryptedString(String s, int k) {
        
        int n = s.length();
        
        k = k%n;
        
        char arr[] = s.toCharArray();
        
        reverse(0,k-1,arr);
        reverse(k,n-1,arr);
        reverse(0,n-1,arr);
        
        return String.valueOf(arr);
    }
    public static void reverse(int l, int h, char arr[]){
        
        while(l <= h){
            
            char temp = arr[h];
            arr[h] = arr[l];
            arr[l] = temp;
            
            l++;
            h--;
        }
    }
}
class Solution {
    public String multiply(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        int arr[] = new int[n1+n2];
        
        for(int i = n2-1 ; i >= 0 ; i--){
            for(int j = n1-1 ; j >= 0 ; j--){
                
                int index = n1-1-i+n2-1-j;
                int cur = (s2.charAt(i)-'0') * (s1.charAt(j) -'0');
                
                int temp = arr[index] + cur;
                arr[index] = temp%10;
                int carry = temp/10;
                arr[index+1] = arr[index+1] + carry;
            }
        }
        
        String ans = "";
        int i = arr.length-1;
        while(i >= 0 && arr[i] == 0){
            i--;
        }
        if(i < 0){
            return "0";
        }
        for( ; i >= 0 ; i--){
            ans += String.valueOf(arr[i]);
        }
        
        return ans;
    }
}
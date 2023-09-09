class Solution {
    public int minimumOperations(String num) {
        
        int n = num.length();
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = i-1 ; j >= 0 ; j--){
                
                int temp = (num.charAt(j)-'0') * 10 + (num.charAt(i)-'0');
                
                if(temp % 25 == 0){
                    ans = Math.min(ans,n-(j+1+1));  // j+1 since j is 0 based indexing
                                                    // +1 for not removing i
                }
                
                // handling 0 at the end but temp % 25 != 0 case...
                
                if(num.charAt(i) == '0'){
                    ans = Math.min(ans,n-1);
                    // n-1 coz we have to remove everything except s[i] which is 0
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? n : ans;
        
        
        // return f(0,"",num);
    }
    public static int f(int index, String temp, String num){
        
        int n = num.length();
        
        if(index == n){
            int len = temp.length();
            if(len == 0 || temp.equals("0")){
                return 0;
            }
            if(len < 2){
                return (int)1e7;
            }
            
            int toInt = Integer.parseInt(""+temp.charAt(len-2)+temp.charAt(len-1));
            
            if(toInt % 25 == 0){
                return 0;
            }
            
            return (int)1e7;
        }
        
        int remove = 1+f(index+1,temp,num);
        int dontRemove = f(index+1,temp+num.charAt(index),num);
        
        return Math.min(remove,dontRemove);
    }
}
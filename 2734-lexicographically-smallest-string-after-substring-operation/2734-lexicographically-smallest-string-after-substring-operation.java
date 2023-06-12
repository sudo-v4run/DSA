class Solution {
    public String smallestString(String s) {
        
        int n = s.length();
        
        char chArr[] = s.toCharArray();
        int i = 0;
        
        while(i < n && chArr[i] == 'a'){
            i++;
        }
        
        if(i >= n){
            chArr[n-1] = 'z';
            return new String(chArr);
        }
        
        System.out.println(i);
        
        while(i < n && chArr[i] != 'a'){
            chArr[i]--;
            i++;
        }
        
        return new String(chArr);
    }
}
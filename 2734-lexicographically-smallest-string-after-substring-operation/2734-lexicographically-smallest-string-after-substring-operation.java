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
            
            // we do this coz we have to perform the operation atleast once.
            // so if there are all a's but since we need the perform the operation
            // atleast once, we change the last a to z.
            // coz Q is about returning the lexicographically smallest after performing
            // the operation. Though aa < az, az is the smallest after performing the
            // operation.
        }
        
        while(i < n && chArr[i] != 'a'){
            chArr[i]--;
            i++;
        }
        
        return new String(chArr);
    }
}
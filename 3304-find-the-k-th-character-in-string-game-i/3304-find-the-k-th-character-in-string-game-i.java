class Solution {
    public char kthCharacter(int k) {
        
        String w = "a";
        
        while(w.length() < k){
            char charr[] = w.toCharArray();
            for(int i = 0 ; i < charr.length ; i++){
                if(charr[i] != 'z'){
                    charr[i]++;
                }else{
                    charr[i] = 'a';
                }
                
            }
            
            w = w + String.valueOf(charr);
        }
        
        return w.charAt(k-1);
    }
}
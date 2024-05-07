class Solution {
    public boolean isValid(String word) {
        
        int n = word.length();
        
        if(n < 3){
            return false;
        }
        
        boolean second = true;
        boolean vowel = false;
        boolean cons = false;
        
        HashSet<Character> vow = new HashSet<>();
        vow.add('a');
        vow.add('e');
        vow.add('i');
        vow.add('o');
        vow.add('u');
        vow.add('A');
        vow.add('E');
        vow.add('I');
        vow.add('O');
        vow.add('U');
        
        for(char ch : word.toCharArray()){
            
            if(!(ch >= '0' && ch <= '9') && 
               !(ch >= 'a' && ch <= 'z') && 
               !(ch >= 'A' && ch <= 'Z')){
                
                second = false;
            }
            if(vow.contains(ch)){
                vowel = true;
            }
            if(!(ch >= '0' && ch <= '9') && !vow.contains(ch)){
                cons = true;
            }
            
        }
        
        return second && vowel && cons;
    }
}
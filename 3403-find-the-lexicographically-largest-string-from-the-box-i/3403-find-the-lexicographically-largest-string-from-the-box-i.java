class Solution {
    public String answerString(String word, int numFriends) {
        
        int n = word.length();
        if(numFriends == 1){
            return word;
        }
        
        String lexoLarge = "";
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            String cur = word.substring(i);
            if(lexoLarge.compareTo(cur) < 0){
                lexoLarge = cur;
                max = i;
            }
        }

        if(max >= numFriends){
            return word.substring(max,n);
        }

        int rem = numFriends-max;

        return word.substring(max,n-rem+1);
    }
}
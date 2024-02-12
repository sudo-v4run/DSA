class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        
        int freq[] = new int[26];
        ArrayList<Integer> strLens = new ArrayList<>();
        
        for(String word : words){
            for(char ch : word.toCharArray()){
                freq[ch-'a']++;
            }
            strLens.add(word.length());
        }
        
        int evens = 0;
        int odds = 0;
        
        for(int f : freq){
            if(f % 2 == 0){
                evens += f;
            }else{
                evens += f-1;
                odds += 1;
            }
        }
        
        Collections.sort(strLens);
        
        int cnt = 0;
        
        for(int curLen : strLens){
            
            int reqEvens = 0;
            if(curLen % 2 == 0){
                reqEvens = curLen;
            }
            
            int reqOdds = 0;        // it is always either 0 or 1
            if(curLen % 2 != 0){
                reqEvens = curLen-1;
                reqOdds = 1;
            }
            
            if(reqEvens > evens){
                break;
            }
            
            evens = evens - reqEvens;
            
            if(reqOdds > odds){
                evens -= 2;
                odds += 2;
            }
            
            odds = odds - reqOdds;
            
            cnt++;
        }
        
        return cnt;
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        
        int n = words.length;
        
        int i = 0;
        while(i < n){
            int len = 0;
            int wordCnt = 0;
            int index = i;
            while(i < n && len+words[i].length() <= maxWidth){
                len += words[i].length();
                wordCnt++;
                len++; // space
                i++;
            }
            len--; // removing trailing space
            
            int extraSpaces = maxWidth-len;
            
            int spaces[];
            if(wordCnt == 1){
                spaces = new int[1];
                spaces[0] = extraSpaces;
            }else{
                spaces = new int[wordCnt-1];
                
                for(int ii = 0 ; extraSpaces > 0 ; ii = (ii+1)%(wordCnt-1)){
                    spaces[ii]++;
                    extraSpaces--;
                }
            }
            
            int spacesArrIndex = 0;
            
            String temp = "";
            for(int j = index ; j < index+wordCnt && j < n ; j++){
                temp += words[j];
                if(j < index+wordCnt-1){
                    temp += " ";
                }
                for(int k = 0 ; spacesArrIndex < spaces.length && 
                                k < spaces[spacesArrIndex] ; k++){
                    temp += " ";
                }
                spacesArrIndex++;
            }
            
            res.add(temp);
        }
        
        // handle last time separately...
        
        String lastStr = res.get(res.size()-1);
        String newLastStr = "";
        i = 0;
        while(i < lastStr.length()){
            while(i < lastStr.length() && lastStr.charAt(i) != ' '){
                newLastStr += lastStr.charAt(i);
                i++;
            }
            if(newLastStr.length() < maxWidth){
                newLastStr += " ";
            }
            while(i < lastStr.length() && lastStr.charAt(i) == ' '){
                i++;
            }
        }
        while(newLastStr.length() < maxWidth){
            newLastStr += " ";
        }
        
        res.remove(res.size()-1);
        res.add(newLastStr);
        
        return res;
    }
}
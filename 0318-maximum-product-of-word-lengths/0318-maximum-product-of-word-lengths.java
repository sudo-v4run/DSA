class Solution {
    public int maxProduct(String[] words) {

        int n = words.length;        
        int or[] = new int[n];

        for(int i = 0; i < n; i++){
            String cur = words[i];
            for(char ch : cur.toCharArray()){
                or[i] = or[i] | (1 << (ch-'a'));
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if((or[i] & or[j]) == 0){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }

        return max;
    }
}
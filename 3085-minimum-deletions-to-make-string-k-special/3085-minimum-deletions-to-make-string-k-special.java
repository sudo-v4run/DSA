class Solution {
    public int minimumDeletions(String word, int k) {
        int count[] = new int[26];
        for(char c: word.toCharArray())
            count[c - 'a']++;
        
        int ans = word.length(), del = 0;
        Arrays.sort(count);
        for(int i = 0; i <26; i++){
            int res = del;
            for(int j = 25; j>i; j--){
                int dif = count[j] - count[i];
                if(dif <= k ) break; // condition satisfied
                res += dif - k; // option when we decrease the freq of max
            }
            ans = Math.min(res,ans);
            del += count[i]; // this value track the option to del the min val
        }
        return ans;
    }
}
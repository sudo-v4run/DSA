class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[] = new int[26];
        
        for(char ch : s.toCharArray()){
            int toAscii = ch-'a';
            arr[toAscii]++;
        }
        
        for(char ch : t.toCharArray()){
            int toAscii = ch-'a';
            arr[toAscii]--;
        }
        
        for(int i : arr){
            if(i!=0){
                return false;
            }
        }
        
        return true;
    }
}
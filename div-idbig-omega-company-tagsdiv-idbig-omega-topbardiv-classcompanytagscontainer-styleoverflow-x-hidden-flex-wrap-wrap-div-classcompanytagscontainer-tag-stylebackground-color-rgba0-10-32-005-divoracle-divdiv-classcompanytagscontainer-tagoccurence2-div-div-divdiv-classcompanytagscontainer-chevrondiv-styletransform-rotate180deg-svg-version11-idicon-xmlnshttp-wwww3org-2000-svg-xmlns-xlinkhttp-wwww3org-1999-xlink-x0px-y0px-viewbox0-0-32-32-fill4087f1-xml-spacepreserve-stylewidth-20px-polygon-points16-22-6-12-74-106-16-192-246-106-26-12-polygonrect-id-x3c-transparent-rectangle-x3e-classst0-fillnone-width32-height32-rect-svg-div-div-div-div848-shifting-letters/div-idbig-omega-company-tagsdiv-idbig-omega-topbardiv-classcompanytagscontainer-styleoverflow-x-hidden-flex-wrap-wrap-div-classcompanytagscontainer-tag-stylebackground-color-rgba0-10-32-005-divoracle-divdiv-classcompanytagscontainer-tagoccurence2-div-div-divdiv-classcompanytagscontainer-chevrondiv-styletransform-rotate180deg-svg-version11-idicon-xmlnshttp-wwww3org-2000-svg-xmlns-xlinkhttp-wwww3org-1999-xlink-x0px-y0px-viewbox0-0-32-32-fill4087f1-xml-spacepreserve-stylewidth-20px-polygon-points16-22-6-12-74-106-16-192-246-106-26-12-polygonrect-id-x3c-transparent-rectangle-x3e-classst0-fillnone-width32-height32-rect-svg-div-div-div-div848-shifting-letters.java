class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        char arr[] = s.toCharArray();
        
        int shiftCnt = 0;
        for(int i = shifts.length-1 ; i >= 0 ; i--){
            
            shiftCnt = (shiftCnt + shifts[i])%26;
            
            arr[i] = (char)((arr[i] - 'a' + shiftCnt) % 26 + 'a');
        }
        
        return new String(arr);
    }
}
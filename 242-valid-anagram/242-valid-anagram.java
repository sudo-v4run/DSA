class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[] = new int[256];
        int n = arr.length;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            arr[(int)(ch)]+=1;
        }
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            arr[(int)(ch)]-=1;
        }
        for(int i = 0 ; i < n ;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
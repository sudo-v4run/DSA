class Solution {
    public String convertDateToBinary(String date) {
        
        String arr[] = date.split("-");
        
        String y = Integer.toBinaryString(Integer.parseInt(arr[0]));
        String m = Integer.toBinaryString(Integer.parseInt(arr[1]));
        String d = Integer.toBinaryString(Integer.parseInt(arr[2]));
        
        return y+"-"+m+"-"+d;
    }
}
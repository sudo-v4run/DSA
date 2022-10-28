public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
        
        for(char i : bin.toCharArray()){
            int num = Integer.parseInt(i+"");
            if((num^0)==1){
                cnt++;
            }
        }
        return cnt;
    }
}
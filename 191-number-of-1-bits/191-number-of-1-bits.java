public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        
        int cnt = 0;
        
        while(n!=0){
            
            cnt = cnt + (n&1);     // or (n%2)
            
            n = n>>>1;             // >> preserves sign bit but >>> does not 
        }
        
        return cnt;
        
        
        
        
//         int cnt = 0;
        
//         while(n!=0){
            
//             if( (n&1) == 1 ){    // or (n%2)==1
//                 cnt++;
//             }
            
//             n = n>>>1;           // >> preserves sign bit but >>> does not
//         }
        
//         return cnt;
        
        
        
        
        
        
//         int cnt = 0;
//         String bin = Integer.toBinaryString(n);
//         System.out.println(bin);
        
//         for(char i : bin.toCharArray()){
//             int num = Integer.parseInt(i+"");
//             if((num^0)==1){
//                 cnt++;
//             }
//         }
//         return cnt;
    }
}
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
 int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
        
        
        
        
//         int cnt = 0;
        
//         while(n!=0){
            
//             if( (n&1) == 1 ){    // or (n%2)==1
//                 cnt++;
//             }
            
//             n = n>>1;
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
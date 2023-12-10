import java.math.BigInteger;  
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        
        int n = variables.length;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            int cur[] = variables[i];
            
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            int m = cur[3];
            
            BigInteger aa = new BigInteger(String.valueOf(a));
            BigInteger result = aa.pow(b);
            BigInteger ten = new BigInteger("10");
            result = result.mod(ten);
            
            result = result.pow(c);
            
            BigInteger mm = new BigInteger(String.valueOf(m));
            result = result.mod(mm); 
            
            BigInteger tar = new BigInteger(String.valueOf(target));
            
            if(result.compareTo(tar) == 0){
                res.add(i);
            }
        }
        
        return res;
    }
}
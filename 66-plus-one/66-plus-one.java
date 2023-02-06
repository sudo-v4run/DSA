import java.math.BigInteger;
class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        
        for(int i = n-1 ; i >= 0 ;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int arr[] = new int[n+1];
        
        arr[0] = 1;
        
        return arr;
        
        
        
        
        
//         String ins = Arrays.toString(digits).replaceAll("\\[|\\]|,|\\s", "");
        
//         BigInteger ans = new BigInteger(ins);
//         BigInteger one = new BigInteger("1");
//         ans = ans.add(one);
        
//         ins = String.valueOf(ans);
        
//         char arr[] = ins.toCharArray();
//         int res[] = new int[arr.length];
        
//         for(int i = 0 ; i < arr.length ; i++){
//             res[i] = Integer.parseInt(arr[i]+"");
//         }
        
//         return res;
    }
}
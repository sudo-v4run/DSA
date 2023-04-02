class Solution {
    public int reverse(int x) {
        
        long rev = 0;
        
        while(x != 0){
            long l = x % 10;
            rev = rev*10 + l;
            if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE){
                return 0;
            }
            x = x/10;
        }
        
        return (int)rev;
    }
    
    
//     public int reverse(int x) {
//         try{
//             String toString = String.valueOf(x);
//             if(x<0){
//                 toString = toString.substring(1);
//             }

//             toString = reverse(toString);

//             int toInt = Integer.parseInt(toString);

//             if(x<0){
//                 return toInt*(-1);
//             }

//             return toInt;
//         }catch(Exception e){
//             return 0;
//         }
   
        
//     }
//     public static String reverse(String s){
//         String rev = "";
        
//         for(int i = s.length()-1; i>=0 ; i--){
//             rev+=s.charAt(i);
//         }
        
//         return rev;
//     }
    
}
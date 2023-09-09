class Solution {
    public String intToRoman(int num){
        
        int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String romans[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0 ; i < values.length ;  i++){
            while(num >= values[i]){
                ans.append(romans[i]);
                num -= values[i];
            }
        }
        
        return ans.toString();
    }
    
    
//     class Pair{
//         int num;
//         String roman;
        
//         Pair(int num, String roman){
//             this.num = num;
//             this.roman = roman;
//         }
//     }
//     Pair arr[];
//     String res;
//     public String intToRoman(int num) {
        
//         arr = new Pair[13];
//         res = "";
        
//         arr[0] = new Pair(1,"I");
//         arr[1] = new Pair(4,"IV");
//         arr[2] = new Pair(5,"V");
//         arr[3] = new Pair(9,"IX");
//         arr[4] = new Pair(10,"X");
//         arr[5] = new Pair(40,"XL");
//         arr[6] = new Pair(50,"L");
//         arr[7] = new Pair(90,"XC");
//         arr[8] = new Pair(100,"C");
//         arr[9] = new Pair(400,"CD");
//         arr[10] = new Pair(500,"D");
//         arr[11] = new Pair(900,"CM");
//         arr[12] = new Pair(1000,"M");
        
//         f(num);
        
//         return res;
//     }
//     public void f(int num){
        
//         if(num == 0){
//             return;
//         }
        
//         Pair romanPair = getRoman(num);
//         res += romanPair.roman;
//         num -= romanPair.num;
        
//         f(num);
//     }
//     public Pair getRoman(int num){
        
//         int s = 0;
//         int e = arr.length-1;
        
//         Pair ans = new Pair(-1,"");
        
//         while(s <= e){
            
//             int mid = s+(e-s)/2;
            
//             if(arr[mid].num <= num){
//                 ans = new Pair(arr[mid].num,arr[mid].roman);
//                 s = mid+1;
//             }else{
//                 e = mid-1;
//             }
//         }
        
//         return ans;
//     }
}
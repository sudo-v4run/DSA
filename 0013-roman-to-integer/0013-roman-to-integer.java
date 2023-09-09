class Solution {
    public int romanToInt(String s) {
        
//         s = s.replace("IV","IIII");
//         s = s.replace("IX","VIIII");
//         s = s.replace("XL","XXXX");
//         s = s.replace("XC","LXXXX");
//         s = s.replace("CD","CCCC");
//         s = s.replace("CM","DCCCC");
        
//         int ans = 0;
        
//         for(char ch : s.toCharArray()){
//             if(ch == 'I'){
//                 ans += 1;
//             }else if(ch == 'V'){
//                 ans += 5;
//             }else if(ch == 'X'){
//                 ans += 10;
//             }else if(ch == 'L'){
//                 ans += 50;
//             }else if(ch == 'C'){
//                 ans += 100;
//             }else if(ch == 'D'){
//                 ans += 500;
//             }else if(ch == 'M'){
//                 ans += 1000;
//             }
//         }
        
//         return ans;
        
        
        int n = s.length();
        
        int arr[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(ch == 'I'){
                arr[i] = 1;
            }else if(ch == 'V'){
                arr[i] = 5;
            }else if(ch == 'X'){
                arr[i] = 10;
            }else if(ch == 'L'){
                arr[i] = 50;
            }else if(ch == 'C'){
                arr[i] = 100;
            }else if(ch == 'D'){
                arr[i] = 500;
            }else if(ch == 'M'){
                arr[i] = 1000;
            }
        }
        
        int ans = 0;
        
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] < arr[i+1]){
                ans -= arr[i];
            }else{
                ans += arr[i];
            }
        }
        
        ans += arr[n-1];
        
        return ans;
    }
}
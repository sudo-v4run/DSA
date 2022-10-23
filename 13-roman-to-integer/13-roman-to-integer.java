class Solution {
//     public int romanToInt(String s) {
        
//         int ans = 0;
        
//         s = s.replace("IV","IIII");
//         s = s.replace("IX","VIIII");
//         s = s.replace("XL","XXXX");
//         s = s.replace("XC","LXXXX");
//         s = s.replace("CD","CCCC");
//         s = s.replace("CM","DCCCC");
        
//         for( int i = s.length()-1 ; i >=0 ; i-- ){
//             char ch = s.charAt(i);
//             if(ch=='I'){
//                 ans+=1;
//             }else if(ch=='V'){
//                 ans+=5;
//             }else if(ch=='X'){
//                 ans+=10;
//             }else if(ch=='L'){
//                 ans+=50;
//             }else if(ch=='C'){
//                 ans+=100;
//             }else if(ch=='D'){
//                 ans+=500;
//             }else{
//                 ans+=1000;
//             }
//         }
        
//         return ans;
//     }
    
    
    public int romanToInt(String s) {
        
    int nums[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
    int sum=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1])
            sum-=nums[i];
        else
            sum+=nums[i];
    }
    return sum+nums[nums.length-1];
}
}


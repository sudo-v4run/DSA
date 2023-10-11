class Solution {
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = n;
        
        do{
            slow = sumOfSqOfDigits(slow);
            fast = sumOfSqOfDigits(fast);
            fast = sumOfSqOfDigits(fast);  
        }while(slow!=fast);
        
        if(slow==1){
            return true;
        }
        
        return false;
        
        
        
        
//         HashSet<Integer> hs = new HashSet<>();
        
//         while(!hs.contains(n)){
//             hs.add(n);
//             n = sumOfSqOfDigits(n);
            
//             if(n==1){
//                 return true;
//             }
//         }
        
//         return false;
        
        
        
        
        // if((n/10)<=0 && n!=1 && n!=7){
        //     return false;
        // }
        // int newN = 0;
        // while(n!=0){
        //     int l = n%10;
        //     newN += l*l;
        //     n = n/10;
        // }
        // if(newN==1){
        //     return true;
        // }else{
        //     return isHappy(newN);
        // }
    }
    
    public static int sumOfSqOfDigits(int n){
        int res = 0;
        
        while(n!=0){
            int l = n%10;
            res = res+l*l;
            n = n/10;
        }
        
        return res;
    }
}
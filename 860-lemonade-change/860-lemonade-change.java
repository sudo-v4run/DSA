class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int n = bills.length;
        
        int five = 0;
        int ten = 0;
        
        for(int i : bills){
            
            if(i == 5) five++;
            else if(i == 10){ five--; ten++; }
            else if(ten > 0){ ten--; five--; }
            else five -= 3;
            
            if(five < 0) return false;
        }
        
        return true;
        
        
        
//         for(int i = 0 ; i < n ; i++){
//             int cur = bills[i];
            
//             if(cur == 5){
//                 five++;
//             }else if(cur == 10){
//                 ten++;
//             }
            
//             while(cur != 5){
//                 if(cur == 20 && ten > 0){
//                     cur -= 10;
//                     ten--;
//                 }else if(five > 0){
//                     cur -= 5;
//                     five--;
//                 }else{
//                     return false;
//                 }
//             }
//         }
        
//         return true;
        
        
        
//         int n = bills.length;
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int i = 0 ; i < n ; i++){
//             int cur = bills[i];
//             hm.put(cur,hm.getOrDefault(cur,0)+1);
            
//             while(cur != 5){
//                 if(cur == 20 && hm.containsKey(10) && hm.get(10) > 0){
//                     cur -= 10;
//                     hm.put(10,hm.get(10)-1);
//                 }else if(hm.containsKey(5) && hm.get(5) > 0){
//                     cur -= 5;
//                     hm.put(5,hm.get(5)-1);
//                 }else{
//                     return false;
//                 }
//             }
//         }
        
//         return true;
        
    }
}
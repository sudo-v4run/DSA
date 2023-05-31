class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int n = bills.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            int cur = bills[i];
            hm.put(cur,hm.getOrDefault(cur,0)+1);
            
            while(cur != 5){
                if(cur == 20 && hm.containsKey(10) && hm.get(10) > 0){
                    cur -= 10;
                    hm.put(10,hm.get(10)-1);
                }else if(hm.containsKey(5) && hm.get(5) > 0){
                    cur -= 5;
                    hm.put(5,hm.get(5)-1);
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
}
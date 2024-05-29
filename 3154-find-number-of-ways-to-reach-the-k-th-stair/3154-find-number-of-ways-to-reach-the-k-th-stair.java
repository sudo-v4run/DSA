class Solution {
    static HashMap<Integer,HashMap<Integer,HashMap<Integer,Integer>>> hm;
    public int waysToReachStair(int k) {
        
        if(k == 0){
            return 2;
        }
        
        hm = new HashMap<>();
     
        return f(1,0,1,k);
    }
    public static int f(int index, int jump, int down, int k){
        
        if(index > 2*k){
            return 0;
        }
        
        if(index < 0){
            return 0;
        }
        
        if(hm.containsKey(index) && hm.get(index).containsKey(jump) 
           && hm.get(index).get(jump).containsKey(down)){
            
            return hm.get(index).get(jump).get(down);
        }
        
        int ans = index == k ? 1 : 0;
        
        
        int op1 = 0;
        if(down == 1){
            op1 = f(index-1,jump,0,k);
        }
        
        int newStair = index+(int)Math.pow(2,jump);
        int op2 = f(newStair,jump+1,1,k);
        
        ans = ans + op1 + op2;
        
        if(!hm.containsKey(index)){
            hm.put(index,new HashMap<>());
        }
        
        if(!hm.get(index).containsKey(jump)){
            hm.get(index).put(jump,new HashMap<>());
        }
        
        hm.get(index).get(jump).put(down,ans);
        
        return ans;
    }
}
class Solution {
    
    static HashMap<Integer,HashMap<List<Integer>,Integer>> dp;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special,
                              List<Integer> needs) {
        
        dp = new HashMap<>();
        return f(0,price,special,needs);
    }
    public static int f(int index, List<Integer> price, List<List<Integer>> special,
                              List<Integer> needs){
        
        if(index == special.size()){
            
            int cost = 0;
            
            for(int i = 0 ; i < needs.size() ; i++){
                
                cost += needs.get(i)*price.get(i);
            }
            
            return cost;
        }
        
        if(dp.containsKey(index) && dp.get(index).containsKey(needs)){
            return dp.get(index).get(needs);
        }
        
        int min = Integer.MAX_VALUE;
        
        List<Integer> curOffer = special.get(index);
        
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0 ; i < needs.size() ; i++){
            if(special.get(index).get(i) > needs.get(i)){
                temp = null;
                break;
            }
            temp.add(needs.get(i)-curOffer.get(i));
        }
        
        if(temp != null){
            int take1 = curOffer.get(curOffer.size()-1) + 
                        f(index+1,price,special,temp);
            
            min = Math.min(min,take1);
            
            int take2 = curOffer.get(curOffer.size()-1) + 
                        f(index,price,special,temp);
            
            min = Math.min(min,take2);
        }
        
        int notTake = f(index+1,price,special,needs);
        
        min = Math.min(min,notTake);
        
        if(!dp.containsKey(index)){
            dp.put(index,new HashMap<>());
        }
        
        dp.get(index).put(needs,min);
        
        return min;
    }
}
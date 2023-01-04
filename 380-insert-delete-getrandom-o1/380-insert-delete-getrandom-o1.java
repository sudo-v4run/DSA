class RandomizedSet {
    
    HashMap<Integer,Integer> hm;
    ArrayList<Integer> list;

    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean isPresent = hm.containsKey(val);
        
        if(!isPresent){
            hm.put(val,list.size());
            list.add(val);
        }
        
        return !isPresent;
    }
    
    public boolean remove(int val) {
        
        boolean isPresent = hm.containsKey(val);
        
        if(isPresent){
            int index = hm.get(val);
            int lastVal = list.get(list.size()-1);
            
            list.set(index,lastVal);
            list.remove(list.size()-1);
            
            hm.put(lastVal,index);
            hm.remove(val);
        }
        
        return isPresent;
    }
    
    public int getRandom() {
        
        Random rand = new Random();
        
        // int randomInd = (int)(Math.random()*list.size());
        
        int randomInd = rand.nextInt(list.size());
        
        return list.get(randomInd);
    }
}
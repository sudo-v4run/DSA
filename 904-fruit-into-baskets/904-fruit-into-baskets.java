class Solution {
    public int totalFruit(int[] fruits) {
        
        // this Q boils down to the Q - Largest substring with k unique characters
        // where k = 2 but atmost k unique characters in this Q...
        
        int k = 2;
        int n = fruits.length;
        int i = 0, j = 0;
        int max = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        while(j < n){
            hm.put(fruits[j],hm.getOrDefault(fruits[j],0)+1);
            
            if(hm.size() <= k){
                max = Math.max(max,j-i+1);
                j++;
            }else if(hm.size() > k){
                while(hm.size() > k){
                    hm.put(fruits[i],hm.get(fruits[i])-1);
                    if(hm.get(fruits[i]) == 0){
                        hm.remove(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}